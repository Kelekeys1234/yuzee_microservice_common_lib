package com.yuzee.common.lib.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yuzee.common.lib.dto.thumbnail.ThumbnailsStoreDTO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.storage.StorageDto;
import com.yuzee.common.lib.enumeration.EntitySubTypeEnum;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "yuzee.storage-handler.enabled", havingValue = "true")
public class StorageHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String STORAGE = "/api/v1/storage";


	private static final String STORE_THUMBNAILS = "/storeThumbnails";

	private static final String DELETE_BY_ID = "/api/v1/storage/entityId/";

	private static final String QUERY_BY_ENTITY_TYPE = "/download/entityType/";

	private static final String QUERY_BY_ENTITY_ID = "/entityId/";

	private static final String QUERY_BY_STORED_FILE_NAME = "/storedFileName/";
	
	private static final String MSG_ERROR_RECEIVED_FROM_STORAGE = "Error response recieved from storage service with error code ";
	
	private static final String MSG_ERROR_INVOKING_STORAGE = "Error invoking storage service {}";
	
	private static final String ENTITY_ID = "entity_id";
	
	private static final String ENTITY_TYPE = "entity_type";
	
	private static final String ENTITY_SUB_TYPE = "entity_sub_type";
	
	private static final String PRIVACY_LEVEL = "privacy_level";
	
	private static final String USER_ID = "userId";

	public List<StorageDto> getStorages(String entityId, EntityTypeEnum entityType, EntitySubTypeEnum entitySubType) {
		return getStorages(Arrays.asList(entityId), entityType, Arrays.asList(entitySubType));
	}

	public List<StorageDto> getStorages(List<String> entityIds, EntityTypeEnum entityType,
			EntitySubTypeEnum entitySubType) {
		List<EntitySubTypeEnum> entitySubTypes = new ArrayList<>();
		entitySubTypes.add(entitySubType);
		return getStorages(entityIds, entityType, entitySubTypes);
	}

	public List<StorageDto> getStorages(List<String> entityIds, EntityTypeEnum entityType,
			List<EntitySubTypeEnum> entitySubTypes) {
		return getStoragesResponse(entityIds, entityType, entitySubTypes, null, null, null, false);
	}

	public void deleteStorageBasedOnEntityId(String entityId) {
		ResponseEntity<Void> response;
		StringBuilder path = new StringBuilder();
		path.append(IConstant.STORAGE_CONNECTION_URL).append(DELETE_BY_ID).append(entityId);
		// adding the query params to the URL
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
		log.info("Calling storage service to delete certificates for asset Id {}", entityId);
		response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, Void.class);
		if (response.getStatusCode().value() != 200) {
			throw new InvokeException(
					MSG_ERROR_RECEIVED_FROM_STORAGE + response.getStatusCode().value());
		}
	}

	public String uploadFileInStorage(final MultipartFile file, final String entityId, EntityTypeEnum entityType,
			EntitySubTypeEnum entitySubType) {
		ResponseEntity<GenericWrapperDto<String>> response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			MultiValueMap<String, Object> formDate = new LinkedMultiValueMap<>();
			File newFile = convert(file);
			formDate.add("file", new FileSystemResource(newFile));

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(IConstant.STORAGE_CONNECTION_URL);
			builder.queryParam(ENTITY_ID, entityId);
			builder.queryParam(ENTITY_TYPE, entityType.name());
			builder.queryParam(ENTITY_SUB_TYPE, entitySubType.name());
			HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(formDate, headers);
			response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST , request, new ParameterizedTypeReference<GenericWrapperDto<String>>() {});
			Files.deleteIfExists(newFile.toPath());
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw new InvokeException(MSG_ERROR_INVOKING_STORAGE);
		}
		return response.getBody().getData();
	}

	private File convert(final MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		if(!convFile.createNewFile()) {
			throw new IOException("Temp file not created");
		}
		try(FileOutputStream fos = new FileOutputStream(convFile)) {
			fos.write(file.getBytes());
		}
		return convFile;
	}

	public List<StorageDto> getStorages(String entityId, EntityTypeEnum entityType,
			EntitySubTypeEnum entitySubType, boolean signUrls) {
		List<String> entityIds = new ArrayList<>();
		entityIds.add(entityId);
		return getStorages(entityIds, entityType, entitySubType,signUrls);
	}

	public List<StorageDto> getStorages(List<String> entityIds, EntityTypeEnum entityType,
			EntitySubTypeEnum entitySubType,boolean signUrls) {
		List<EntitySubTypeEnum> entitySubTypeEnums = new ArrayList<>();
		entitySubTypeEnums.add(entitySubType);
		return getStorages(entityIds, entityType, entitySubTypeEnums,signUrls);
	}

	public List<StorageDto> getStorages(List<String> entityIds, EntityTypeEnum entityType,
			List<EntitySubTypeEnum> entitySubTypeEnums, boolean signUrls){
		return getStoragesResponse(entityIds, entityType, entitySubTypeEnums, null, null, null, signUrls);	
	}
	

	public PaginationResponseDto<List<StorageDto>> getMediaPagenated(List<String> entityIds, List<EntityTypeEnum> entityTypes,
			List<EntitySubTypeEnum> entitySubTypeEnums, boolean signUrls, List<String> mimeTypes, String parentEntityId,Integer pageNumber, Integer pageSize) {
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<StorageDto>>>> getStoragesResponse = null;
		Assert.notEmpty(entityTypes, "entity_type is required");
		Assert.notEmpty(entitySubTypeEnums, "entity_sub_type is required");
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.STORAGE_CONNECTION_URL).append(STORAGE);
			// adding the query params to the URL
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			if(!CollectionUtils.isEmpty(entityIds)) {
				entityIds.stream().forEach(e -> uriBuilder.queryParam(ENTITY_ID, e));				
			}
			entityTypes.stream().forEach(e -> uriBuilder.queryParam(ENTITY_TYPE, e));
			entitySubTypeEnums.forEach(subType -> uriBuilder.queryParam(ENTITY_SUB_TYPE,subType));
			uriBuilder.queryParam("sign_urls", signUrls);
			if(!CollectionUtils.isEmpty(mimeTypes)) {
				mimeTypes.stream().forEach(e -> uriBuilder.queryParam("mime_type", e));
			}
			if(!StringUtils.isEmpty(parentEntityId)) {
				uriBuilder.queryParam("parent_entity_id", parentEntityId);
			}
			if(!ObjectUtils.isEmpty(pageNumber) && !ObjectUtils.isEmpty(pageSize)) {
				uriBuilder.queryParam("page_number", pageNumber);
				uriBuilder.queryParam("page_size", pageSize);
			}
			
			log.info("Calling storage service to fetch for entity Id {} and entity_sub_types {}",entityIds,entitySubTypeEnums);
			getStoragesResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<StorageDto>>>>() {});
			if (getStoragesResponse.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_RECEIVED_FROM_STORAGE
						+ getStoragesResponse.getStatusCode().value());
			}

		}
		catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw new InvokeException(MSG_ERROR_INVOKING_STORAGE);
		}
		return getStoragesResponse.getBody().getData();
	}
	
	public void streamStorageResource(OutputStream outputStream,EntityTypeEnum entityType, String entityId, String storedFileName) {
		StringBuilder path = new StringBuilder();
		path.append(IConstant.STORAGE_CONNECTION_URL).append(STORAGE);
		path.append(QUERY_BY_ENTITY_TYPE).append(entityType);
		path.append(QUERY_BY_ENTITY_ID).append(entityId);
		path.append(QUERY_BY_STORED_FILE_NAME).append(storedFileName);
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());

		log.info("Streaming Storage Resource from uri "+uriBuilder.toUriString());
		restTemplate.execute(uriBuilder.toUriString(), 
				HttpMethod.GET,
				(ClientHttpRequest requestCallback) -> {
					//nothing to be done for now.
				},
				responseExtractor -> {
					StreamUtils.copy(responseExtractor.getBody(), outputStream);
					return null;
				});
	}
	
	public List<StorageDto> getStoragesByStorageIdAndMimeTypes(List<String> storageIds, List<String> mimeTypes, boolean signUrls) {
		return getStoragesResponse(null, null, null, storageIds, mimeTypes, null,signUrls);
	}
	
	private List<StorageDto> getStoragesResponse(List<String> entityIds, EntityTypeEnum entityType,
			List<EntitySubTypeEnum> entitySubTypeEnums, List<String> storageIds, List<String> mimeTypes,
			List<String> privacyLevels, boolean signUrls) {
		ResponseEntity<GenericWrapperDto<List<StorageDto>>> getStoragesResponse = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.STORAGE_CONNECTION_URL).append(STORAGE);
			// adding the query params to the URL
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			if(!CollectionUtils.isEmpty(entityIds)) {
				entityIds.stream().forEach(e -> uriBuilder.queryParam(ENTITY_ID, e));				
			}
			if(!ObjectUtils.isEmpty(entityType)) {
				uriBuilder.queryParam(ENTITY_TYPE, entityType.name());				
			}
			if(!CollectionUtils.isEmpty(entitySubTypeEnums)) {
				entitySubTypeEnums.forEach(subType -> uriBuilder.queryParam(ENTITY_SUB_TYPE,subType));				
			}
			if(!CollectionUtils.isEmpty(storageIds)) {
				storageIds.stream().forEach(e -> uriBuilder.queryParam("storage_id", e));
			}
			if(!CollectionUtils.isEmpty(mimeTypes)) {
				mimeTypes.stream().forEach(e -> uriBuilder.queryParam("mime_type", e));
			}
			if(!CollectionUtils.isEmpty(privacyLevels)) {
				privacyLevels.forEach(privacyLevel -> uriBuilder.queryParam("privacy_level", privacyLevel));
			}
			uriBuilder.queryParam("sign_urls", signUrls);
			log.info("Calling storage service to fetch for entity Id {} and entity_sub_types {}",entityIds,entitySubTypeEnums);
			getStoragesResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<StorageDto>>>() {});
			if (getStoragesResponse.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_RECEIVED_FROM_STORAGE
						+ getStoragesResponse.getStatusCode().value());
			}

		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw new InvokeException(MSG_ERROR_INVOKING_STORAGE);
		}
		return getStoragesResponse.getBody().getData();
	}
	
	
	public List<StorageDto> getStorages(String entityId, EntityTypeEnum entityType,
			EntitySubTypeEnum entitySubType, List<String> privacyLevels) {
		List<String> entityIds = new ArrayList<>();
		entityIds.add(entityId);
		return getStorages(entityIds, entityType, entitySubType,privacyLevels);
	}
	
	public List<StorageDto> getStorages(List<String> entityIds, EntityTypeEnum entityType,
			EntitySubTypeEnum entitySubType , List<String> privacyLevels){
		List<EntitySubTypeEnum> entitySubTypeEnums = new ArrayList<>();
		entitySubTypeEnums.add(entitySubType);
		return getStorages(entityIds, entityType, entitySubTypeEnums,privacyLevels);
	}
	
	public List<StorageDto> getStorages(List<String> entityIds, EntityTypeEnum entityType,
			List<EntitySubTypeEnum> entitySubTypeEnums, List<String> privacyLevels) {
		return getStoragesResponse(entityIds, entityType, entitySubTypeEnums, null, null, privacyLevels, false);
	}
	
	public void copyStorage(String userId, String entityId, EntityTypeEnum entityType,
			EntitySubTypeEnum entitySubType, String copyFrom, String parentEntityId) {
		ResponseEntity<GenericWrapperDto<String>> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(USER_ID, userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			StringBuilder path = new StringBuilder();
			path.append(IConstant.STORAGE_CONNECTION_URL).append(STORAGE);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("copy_from", copyFrom);
			uriBuilder.queryParam("entity_id", entityId);
			uriBuilder.queryParam("entity_type", entityType);
			uriBuilder.queryParam("entity_sub_type", entitySubType);
			uriBuilder.queryParam("parent_entity_id", parentEntityId);

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_RECEIVED_FROM_STORAGE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw new InvokeException(MSG_ERROR_INVOKING_STORAGE);
		}
	}


	public GenericWrapperDto<Object> storeThumbnails(ThumbnailsStoreDTO thumbnailsStoreDTO) {
		ResponseEntity<GenericWrapperDto<Object>> getStoragesResponse;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.STORAGE_CONNECTION_URL).append(STORAGE).append(STORE_THUMBNAILS);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<ThumbnailsStoreDTO> requestEntity = new HttpEntity<>(thumbnailsStoreDTO, headers);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());


			log.info("Calling storage service to store thumbnails for storage Id : {} ", thumbnailsStoreDTO.getStorageId());
			getStoragesResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, requestEntity, new ParameterizedTypeReference<GenericWrapperDto<Object>>() {});
			if (getStoragesResponse.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_RECEIVED_FROM_STORAGE + getStoragesResponse.getStatusCode().value());
			}

		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_STORAGE, e);
			throw new InvokeException(MSG_ERROR_INVOKING_STORAGE);
		}
		return getStoragesResponse.getBody();
	}
}
