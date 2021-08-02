package com.yuzee.common.lib.handler;

import java.util.List;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.GenericRequestWrapper;
import com.yuzee.common.lib.dto.GenericResponse;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.authorization.AuthUserDTO;
import com.yuzee.common.lib.dto.authorization.CreateUserDto;
import com.yuzee.common.lib.dto.authorization.PermissionDto;
import com.yuzee.common.lib.dto.authorization.PermissionListDto;
import com.yuzee.common.lib.dto.authorization.ResourceDto;
import com.yuzee.common.lib.dto.authorization.ResourcePermissionDto;
import com.yuzee.common.lib.dto.authorization.RoleBasedPolicyDto;
import com.yuzee.common.lib.dto.authorization.RoleDto;
import com.yuzee.common.lib.dto.authorization.ScopeDto;
import com.yuzee.common.lib.dto.user.UserAccessToken;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "authorization.config.file")
public class AuthorizationHandler {

	@Autowired
	private RestTemplate restTemplate;

	private static final String AUTHORIZATION_API = IConstant.AUTHORIZATION_BASE_PATH + "/api/v1/provisioning/authorization";
	private static final String SCOPE_API = AUTHORIZATION_API + "/scope";
	private static final String SCOPE_BASED_POLICY_API = AUTHORIZATION_API + "/role-based-policy";
	private static final String RESOURCE_API = AUTHORIZATION_API + "/resource";
	private static final String RESOURCE_PERMISSION_API = AUTHORIZATION_API + "/permission";

	private static final String ROLE = IConstant.AUTHORIZATION_BASE_PATH + "/api/v1/provisioning/role";
	private static final String USER = IConstant.AUTHORIZATION_BASE_PATH + "/api/v1/provisioning/user";
	private static final String TOKEN = IConstant.AUTHORIZATION_BASE_PATH + "/api/v1/provisioning/token";

	private static final String CREATE_ROLE_API = ROLE + "/createrole";
	
	private static final String CREATE_TOKEN_API = TOKEN + "/createtoken";
	
	private static final String FIND_USER_BY_EMAIL_API = USER + "/finduserbyemail";
	private static final String CREATE_USER_API = USER + "/createuser";
	private static final String UPDATE_USER_API = USER + "/updateuser";
	private static final String ADD_USER_ROLES = USER + "/adduserroles";
	private static final String REMOVE_USER_ROLES = USER + "/removeuserroles";
	private static final String ACTIVATE_USER = USER + "/activateuser";
	private static final String DEACTIVATE_USER = USER + "/deactivateuser";
	private static final String SET_EMAIL_VERIFIED = USER + "/setemailverified";
	private static final String UPDATE_PASSWORD = USER + "/updatepassword";
	private static final String GET_USER_ROLES = USER + "/getuserroles";
	private static final String UPDATE_PERMISSIONS = USER + "/updatepermissions";
	private static final String GET_USER_PERMISSIONS = USER + "/getuserpermission";
	
	private static final String MSG_ERROR_FROM_AUTH_SERVICE = "Error response recieved from authorization service with error code ";
	private static final String MSG_ERROR_INVOKING_AUTH_SERVICE = "Error invoking Authorization service";
	
	private static final String USER_ID = "userId";
	private static final String EMAIL_VERIFIED = "emailVerified";
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";
	private static final String ROLE_IDS = "roleIds";
	

	public void createOrUpdateScopes(GenericRequestWrapper<ScopeDto> scopes){
		log.info("Creating scopes");
		try {
			HttpEntity<GenericRequestWrapper<ScopeDto>> request = new HttpEntity<>(scopes);
			ResponseEntity<GenericResponse> responseEntity = restTemplate.exchange(SCOPE_API,HttpMethod.PUT, request , GenericResponse.class);
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		}catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		} 
	}

	public void createOrUpdateRoleBasedPolicies(GenericRequestWrapper<RoleBasedPolicyDto> roleBasedPolicies){
		log.info("Creating role based policies");
		try {
			HttpEntity<GenericRequestWrapper<RoleBasedPolicyDto>> request = new HttpEntity<>(roleBasedPolicies);
			ResponseEntity<GenericResponse> responseEntity = restTemplate.exchange(SCOPE_BASED_POLICY_API,HttpMethod.PUT, request , GenericResponse.class);
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		}catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		} 
	}

	public void createOrUpdateResources(GenericRequestWrapper<ResourceDto> resources){
		log.info("Creating resources");
		try {
			HttpEntity<GenericRequestWrapper<ResourceDto>> request = new HttpEntity<>(resources);
			ResponseEntity<GenericResponse> responseEntity = restTemplate.exchange(RESOURCE_API,HttpMethod.PUT, request , GenericResponse.class);
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		}catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		} 
	}

	public void createOrUpdateResourcePermissions(GenericRequestWrapper<ResourcePermissionDto> permissions){
		log.info("Creating resources");
		try {
			HttpEntity<GenericRequestWrapper<ResourcePermissionDto>> request = new HttpEntity<>(permissions);
			ResponseEntity<GenericResponse> responseEntity = restTemplate.exchange(RESOURCE_PERMISSION_API,HttpMethod.PUT, request , GenericResponse.class);
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		}catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		} 
	}
	public RoleDto createRole(RoleDto role) {
		ResponseEntity<GenericWrapperDto<RoleDto>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(CREATE_ROLE_API);
			HttpEntity<RoleDto> request = new HttpEntity<>(role);

			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, request,
					new ParameterizedTypeReference<GenericWrapperDto<RoleDto>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public AuthUserDTO findUserByEmail(String email) {
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(FIND_USER_BY_EMAIL_API);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam("email", email);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public AuthUserDTO createUser(CreateUserDto createUserDto) {
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(CREATE_USER_API);
			HttpEntity<CreateUserDto> request = new HttpEntity<>(createUserDto);

			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, request,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public AuthUserDTO updateUser(String userId, CreateUserDto createUserDto) {
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<CreateUserDto> entity = new HttpEntity<>(createUserDto,headers);
			StringBuilder path = new StringBuilder();
			path.append(UPDATE_USER_API);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<RoleDto> addUserRoles(String userId, List<String> roleIds) {
		ResponseEntity<GenericWrapperDto<List<RoleDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(ADD_USER_ROLES);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			roleIds.stream().forEach(e -> builder.queryParam(ROLE_IDS, e));
			builder.queryParam(USER_ID, userId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<RoleDto>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<RoleDto> removeUserRoles(String userId, List<String> roleIds) {
		ResponseEntity<GenericWrapperDto<List<RoleDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(REMOVE_USER_ROLES);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			roleIds.stream().forEach(e -> builder.queryParam(ROLE_IDS, e));
			builder.queryParam(USER_ID, userId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<RoleDto>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}

		return responseEntity.getBody().getData();
	}
	

	public AccessTokenResponse createToken(UserAccessToken userAccessToken) {
		ResponseEntity<GenericWrapperDto<AccessTokenResponse>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<UserAccessToken> entity = new HttpEntity<>(userAccessToken,headers);
			StringBuilder path = new StringBuilder();
			path.append(CREATE_TOKEN_API);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<AccessTokenResponse>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	
	public List<RoleDto> getRoles() {
		ResponseEntity<GenericWrapperDto<List<RoleDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(ROLE);

			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<RoleDto>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public AuthUserDTO getUser(String userId) {
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(USER);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public void setEmailVerified(String userId, boolean emailVerified) {
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(SET_EMAIL_VERIFIED);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);
			builder.queryParam(EMAIL_VERIFIED, emailVerified);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
	}
	
	public void activateUser(String userId) {
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(ACTIVATE_USER);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
	}
	
	public void deactivateUser(String userId) {
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(DEACTIVATE_USER);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
	}
	
	public void updatePassword(String userId, String password) {
		ResponseEntity<GenericWrapperDto<String>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(UPDATE_PASSWORD);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);
			builder.queryParam(PASSWORD, password);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
	}
	
	public List<RoleDto> getUserRoles(String userId) {
		ResponseEntity<GenericWrapperDto<List<RoleDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(GET_USER_ROLES);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);

			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<RoleDto>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
	
	public void updatePermissions(String userId, List<PermissionDto> permissions) {
		log.info("Inside AuthoriationHandler.updatePermission");
		PermissionListDto permissionListDto = new PermissionListDto(); 
		permissionListDto.setPermissions(permissions);
		ResponseEntity<GenericWrapperDto<AuthUserDTO>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<PermissionListDto> entity = new HttpEntity<>(permissionListDto,headers);
			StringBuilder path = new StringBuilder();
			path.append(UPDATE_PERMISSIONS);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);
			
			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<AuthUserDTO>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException("Error response recieved from Authorization service with error code "
						+ responseEntity.getStatusCode().value());
			}
		} catch (Exception e) {
			log.error("Error invoking authorization service");
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
	}
	
	public List<PermissionDto> getUserPermissions(final String userId) {
		ResponseEntity<GenericWrapperDto<List<PermissionDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			StringBuilder path = new StringBuilder();
			path.append(GET_USER_PERMISSIONS);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(path.toString());
			builder.queryParam(USER_ID, userId);

			responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity,
					new ParameterizedTypeReference<GenericWrapperDto<List<PermissionDto>>>() {
			});
			if (responseEntity.getStatusCode().value() != 200) {
				throw new InvokeException(MSG_ERROR_FROM_AUTH_SERVICE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException | NotFoundException e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw e;
		}
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING_AUTH_SERVICE,e);
			throw new InvokeException(MSG_ERROR_INVOKING_AUTH_SERVICE);
		}
		return responseEntity.getBody().getData();
	}
}
