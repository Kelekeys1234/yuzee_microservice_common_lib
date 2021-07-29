package com.yuzee.common.lib.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.elastic.CourseBasicInfoDto;
import com.yuzee.common.lib.dto.elastic.ElasticSearchBulkWrapperDto;
import com.yuzee.common.lib.dto.elastic.ElasticSearchDTO;
import com.yuzee.common.lib.dto.elastic.NetworkElasticDto;
import com.yuzee.common.lib.dto.elastic.UserElasticDto;
import com.yuzee.common.lib.dto.institute.ArticleElasticSearchDto;
import com.yuzee.common.lib.dto.institute.CourseDTOElasticSearch;
import com.yuzee.common.lib.dto.institute.FacultyDto;
import com.yuzee.common.lib.dto.institute.InstituteElasticSearchDTO;
import com.yuzee.common.lib.dto.institute.LevelDto;
import com.yuzee.common.lib.dto.institute.ScholarshipElasticDto;
import com.yuzee.common.lib.enumeration.EntityTypeEnum;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@ConditionalOnProperty(name = "yuzee.elastic-handler.enabled", havingValue = "true")
@Slf4j
public class ElasticHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String SYNC_NETWORK = "api/v1/sync/network";
	
	private static final String MSG_ERROR_INVOKING_ELASTIC = "Error invoking elastic service";
	private static final String MSG_ERROR_CODE = "Error response recieved from elastic service with error code ";
	
	private static final String GET_COURSE_BASIC_INFO_FILTER_URL = IConstant.ELASTIC_SEARCH_URL+ "api/v1/course/basic_info";
	
	public void syncNetworkWithElastic (NetworkElasticDto networkElasticDto){
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.ELASTIC_SEARCH_URL).append(SYNC_NETWORK);
			ResponseEntity<String> status = restTemplate.postForEntity(path.toString(), networkElasticDto, String.class);
			if(status.getStatusCodeValue() != 200) {
				log.error(MSG_ERROR_CODE + status.getStatusCodeValue());
				throw new InvokeException(MSG_ERROR_CODE + status.getStatusCodeValue());
			}
		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC, e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC, e);
			throw new InvokeException(MSG_ERROR_INVOKING_ELASTIC);
		}
	}
	
	public void saveUpdateInstitutes(List<InstituteElasticSearchDTO> institutes) {
		List<ElasticSearchDTO> entities = institutes.stream().map(e -> {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
			elasticSearchDto.setType(EntityTypeEnum.INSTITUTE.name());
			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
			elasticSearchDto.setObject(e);
			return elasticSearchDto;
			
		}).collect(Collectors.toList());
		saveDataOnElasticSearchInBulk(new ElasticSearchBulkWrapperDto(entities));
	}


	public void saveInsituteOnElasticSearch(final String elasticSearchIndex, final String type, final List<InstituteElasticSearchDTO> instituteList) {
		for (InstituteElasticSearchDTO insitute : instituteList) {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(elasticSearchIndex);
			elasticSearchDto.setType(type);
			elasticSearchDto.setEntityId(String.valueOf(insitute.getId()));
			elasticSearchDto.setObject(insitute);
			restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL, elasticSearchDto, Object.class);
		}
	}

	public void updateInsituteOnElasticSearch(final String elasticSearchIndex, final String type, final List<InstituteElasticSearchDTO> instituteList) {
		for (InstituteElasticSearchDTO insitute : instituteList) {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(elasticSearchIndex);
			elasticSearchDto.setType(type);
			elasticSearchDto.setEntityId(String.valueOf(insitute.getId()));
			elasticSearchDto.setObject(insitute);
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
			restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.PUT, httpEntity, Object.class);
		}
	}

	public void deleteInsituteOnElasticSearch(final String elasticSearchIndex, final String type, final List<InstituteElasticSearchDTO> instituteList) {
		for (InstituteElasticSearchDTO insitute : instituteList) {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(elasticSearchIndex);
			elasticSearchDto.setType(type);
			elasticSearchDto.setEntityId(String.valueOf(insitute.getId()));
			elasticSearchDto.setObject(insitute);
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
			restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Object.class);
		}
	}

	public void deleteCourseOnElasticSearch(final String elasticSearchIndex, final String type, final List<CourseDTOElasticSearch> courseList) {
		for (CourseDTOElasticSearch courseElasticSearch : courseList) {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(elasticSearchIndex);
			elasticSearchDto.setType(type);
			elasticSearchDto.setEntityId(String.valueOf(courseElasticSearch.getId()));
			elasticSearchDto.setObject(courseElasticSearch);
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
			restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Map.class);
		}
	}
	
	public void saveUpdateData(List<CourseDTOElasticSearch> courseList) {
		List<ElasticSearchDTO> entities = courseList.stream().map(e -> {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
			elasticSearchDto.setType(EntityTypeEnum.COURSE.name());
			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
			elasticSearchDto.setObject(e);
			return elasticSearchDto;

		}).collect(Collectors.toList());
		saveDataOnElasticSearchInBulk(new ElasticSearchBulkWrapperDto(entities));
	}

	public void saveDataOnElasticSearchInBulk(ElasticSearchBulkWrapperDto elasticSearchBulkWrapperDto) {
		StringBuilder path = new StringBuilder();
		path.append(IConstant.ELASTIC_SEARCH_BULK);
		restTemplate.postForEntity(path.toString(), elasticSearchBulkWrapperDto, Object.class);
	}

	public void saveArticleOnElasticSearch(final String elasticSearchIndex, final String type, final ArticleElasticSearchDto articleDto) {
		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
		elasticSearchDto.setIndex(elasticSearchIndex);
		elasticSearchDto.setType(type);
		elasticSearchDto.setEntityId(String.valueOf(articleDto.getId()));
		elasticSearchDto.setObject(articleDto);
		log.info("{}",elasticSearchDto);
		restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL, elasticSearchDto, Object.class);
	}

	public void updateArticleOnElasticSearch(final String elasticSearchIndex, final String type, final ArticleElasticSearchDto articleDto) {
		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
		elasticSearchDto.setIndex(elasticSearchIndex);
		elasticSearchDto.setType(type);
		elasticSearchDto.setEntityId(String.valueOf(articleDto.getId()));
		elasticSearchDto.setObject(articleDto);
		log.info("{}",elasticSearchDto);
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
		restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.PUT, httpEntity, Object.class);
	}

	public void deleteArticleOnElasticSearch(final String elasticSearchIndex, final String type, final ArticleElasticSearchDto articleDto) {
		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
		elasticSearchDto.setIndex(elasticSearchIndex);
		elasticSearchDto.setType(type);
		elasticSearchDto.setEntityId(String.valueOf(articleDto.getId()));
		elasticSearchDto.setObject(articleDto);
		log.info("{}",elasticSearchDto);
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
		restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Object.class);
	}

	public void saveUpdateScholarship(final ScholarshipElasticDto scholarshipDto) {
		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
		elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
		elasticSearchDto.setType(EntityTypeEnum.SCHOLARSHIP.name());
		elasticSearchDto.setEntityId(String.valueOf(scholarshipDto.getId()));
		elasticSearchDto.setObject(scholarshipDto);
		log.info("{}",elasticSearchDto);
		restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL, elasticSearchDto, Object.class);
	}

	public void deleteScholarshipOnElasticSearch(final String elasticSearchIndex, final String type, final ScholarshipElasticDto scholarshipDto) {
		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
		elasticSearchDto.setIndex(elasticSearchIndex);
		elasticSearchDto.setType(type);
		elasticSearchDto.setEntityId(String.valueOf(scholarshipDto.getId()));
		elasticSearchDto.setObject(scholarshipDto);
		log.info("{}",elasticSearchDto);
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ElasticSearchDTO> httpEntity = new HttpEntity<>(elasticSearchDto, headers);
		restTemplate.exchange(IConstant.ELASTIC_SEARCH_URL, HttpMethod.DELETE, httpEntity, Object.class);
	}
	
	public void addUpdateUserDetailsOnElastic(UserElasticDto userElasticDto){
		log.debug("Inside saveInsituteOnElasticSearch() method");
		List<ElasticSearchDTO> elasticSearchDtoList = new ArrayList<>();
		ElasticSearchBulkWrapperDto elasticSearchBulkWrapperDto = new ElasticSearchBulkWrapperDto();

		ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
		elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX_GENERIC);
		elasticSearchDto.setType(IConstant.ELASTIC_SEARCH_USER_TYPE);
		elasticSearchDto.setEntityId(String.valueOf(userElasticDto.getId()));
		elasticSearchDto.setObject(userElasticDto);
		elasticSearchDtoList.add(elasticSearchDto);

		elasticSearchBulkWrapperDto.setEntities(elasticSearchDtoList);
		this.saveDataOnElasticSearchInBulk(elasticSearchBulkWrapperDto);
	}
	
	public void saveUserOnElasticSearch(String elasticSearchIndex, String type, List<UserElasticDto> userElasticDtoList) {
		ResponseEntity<Object> object = null;
		try {
			log.debug("Inside saveUserOnElasticSearch() method");
			for (UserElasticDto userElasticDto : userElasticDtoList) {
				ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
				elasticSearchDto.setIndex(elasticSearchIndex);
				elasticSearchDto.setType(type);
				elasticSearchDto.setEntityId(String.valueOf(userElasticDto.getId()));
				elasticSearchDto.setObject(userElasticDto);
				log.info("{}",elasticSearchDto);
				object = restTemplate.postForEntity(IConstant.ELASTIC_SEARCH_URL,elasticSearchDto, Object.class);
				if(object.getStatusCode().value() != 200) {
					log.error(MSG_ERROR_CODE + object.getStatusCodeValue());
					throw new InvokeException(MSG_ERROR_CODE
							+ object.getStatusCode().value());
				}
			}
		}catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC, e);
		}
	}
	
	public void saveUpdateFaculties(List<FacultyDto> faculties) {
		List<ElasticSearchDTO> entities = faculties.stream().map(e -> {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
			elasticSearchDto.setType(EntityTypeEnum.FACULTY.name());
			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
			elasticSearchDto.setObject(e);
			return elasticSearchDto;
			
		}).collect(Collectors.toList());
		saveDataOnElasticSearchInBulk(new ElasticSearchBulkWrapperDto(entities));
	}

	public void saveUpdateLevels(List<LevelDto> level) {
		List<ElasticSearchDTO> entities = level.stream().map(e -> {
			ElasticSearchDTO elasticSearchDto = new ElasticSearchDTO();
			elasticSearchDto.setIndex(IConstant.ELASTIC_SEARCH_INDEX);
			elasticSearchDto.setType(EntityTypeEnum.LEVEL.name());
			elasticSearchDto.setEntityId(String.valueOf(e.getId()));
			elasticSearchDto.setObject(e);
			return elasticSearchDto;
			
		}).collect(Collectors.toList());
		saveDataOnElasticSearchInBulk(new ElasticSearchBulkWrapperDto(entities));
	}
	
	public PaginationResponseDto<List<CourseBasicInfoDto>> getFilterCoursesBasicInfo(String instituteId, List<String> facultyName,List<String> levelName,int pageNumber ,int pageSize){
		ResponseEntity<GenericWrapperDto<PaginationResponseDto<List<CourseBasicInfoDto>>>> courseDtoDtoResponse = null;

		try {
			StringBuilder path = new StringBuilder();
			path.append(GET_COURSE_BASIC_INFO_FILTER_URL)
			.append("/pageNumber/").append(pageNumber).append("/pageSize/").append(pageSize);
			
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("institute_id", instituteId);
			levelName.stream().forEach(e -> uriBuilder.queryParam("level_name", e));
			facultyName.stream().forEach(e -> uriBuilder.queryParam("faculty_names", e));
			courseDtoDtoResponse = restTemplate.exchange(uriBuilder.build(false).toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<GenericWrapperDto<PaginationResponseDto<List<CourseBasicInfoDto>>>>() {});
			if (courseDtoDtoResponse.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE + courseDtoDtoResponse.getStatusCode().value() );
				throw new InvokeException(MSG_ERROR_CODE + courseDtoDtoResponse.getStatusCode().value() );
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_ELASTIC,e);
			throw new InvokeException(MSG_ERROR_INVOKING_ELASTIC);
		}
		return courseDtoDtoResponse.getBody().getData();
	}

}
