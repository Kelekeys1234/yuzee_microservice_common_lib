package com.yuzee.common.lib.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.CountDto;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.dto.institute.CourseDto;
import com.yuzee.common.lib.dto.institute.EducationSystemDto;
import com.yuzee.common.lib.dto.institute.GradeDto;
import com.yuzee.common.lib.dto.institute.InstituteBasicInfoDto;
import com.yuzee.common.lib.dto.institute.InstituteDto;
import com.yuzee.common.lib.dto.institute.InstituteRequestDto;
import com.yuzee.common.lib.dto.institute.InstituteWrapperDto;
import com.yuzee.common.lib.dto.institute.LevelDto;
import com.yuzee.common.lib.dto.institute.ScholarshipDto;
import com.yuzee.common.lib.exception.InvokeException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.institute.enabled", havingValue = "true")
public class InstituteHandler {


	private static final String GET_COURSE_BY_ID = "/course/courseIds";
	private static final String GET_INSTITUTE_BY_ID = "/public/basic/info";
	private static final String GET_LEVEL_BY_ID = "/level/{levelId}";
	private static final String GET_INSTITUTE_DETAIL_INFO_BY_ID = "/{instituteId}" ;
	private static final String GET_EDUCATION_SYSTEM_BY_ID = "/educationSystem/system/{systemId}" ;
	private static final String GET_SCHOLARSHIP_BY_ID = "/scholarship/multiple/id";
	private static final String GET_INSTITUTE_BY_MULTIPLE_ID = "/institute/multiple/id";
	private static final String UPDATE_PROCEDURE_ID = "/course/procedure_id";
	private static final String UPDATE_PROCEDURE_ID_BY_INSITUTE_ID = "/institute_id";
	private static final String GET_IS_CAREER_TEST_COMPLETED= "/career-test-result/is-completed";
	private static final String CALCULATE_GRADE= "/grade/calculate";
	private static final String USER_ID = "userId";
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String MSG_ERROR_CODE = "Error response recieved from Institute service with error code ";
	private static final String MSG_ERROR_INVOKING = "Error invoking Institute service";
	private static final String MSG_ERROR_NOT_FOUND = "Institute for supplied instituteId not found";
	
	
	public InstituteBasicInfoDto getInstituteById(String instituteId) {
		return getInstituteById(instituteId, false);
	}
	public InstituteBasicInfoDto getInstituteById(String instituteId, boolean includeDetail){
		ResponseEntity<GenericWrapperDto<InstituteBasicInfoDto>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_INSTITUTE_BY_ID).append("/").append(instituteId);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("includeDetail", includeDetail);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			HttpEntity<String> request = new HttpEntity<>(headers);

			log.info("Request URI: {}",uriBuilder.toUriString());
			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, request,
					new ParameterizedTypeReference<GenericWrapperDto<InstituteBasicInfoDto>>() {});

			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		}catch (NotFound e) {
			log.error(MSG_ERROR_NOT_FOUND, e);
			throw new NotFoundException(MSG_ERROR_NOT_FOUND);
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	public List<CourseDto> getCourseByIds(List<String> courseIds) {
		ResponseEntity<InstituteWrapperDto> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_COURSE_BY_ID);
			HttpEntity<List<String>> body = new HttpEntity<>(courseIds);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, body, InstituteWrapperDto.class);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<ScholarshipDto> getScholarships(List<String> instituteIds) {
		ResponseEntity<GenericWrapperDto<List<ScholarshipDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_SCHOLARSHIP_BY_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			instituteIds.stream().forEach(e -> uriBuilder.queryParam("scholarship_ids", e));

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<ScholarshipDto>>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public List<InstituteDto> getInstitutes(List<String> instituteIds) {
		ResponseEntity<GenericWrapperDto<List<InstituteDto>>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_INSTITUTE_BY_MULTIPLE_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			instituteIds.stream().forEach(e -> uriBuilder.queryParam("institute_ids", e));

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<List<InstituteDto>>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public boolean checkIfCareerTestCompleted(String userId) {
		ResponseEntity<GenericWrapperDto<Boolean>> response = null;
		try {
			Map<String, String> params = new HashMap<>();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(USER_ID, userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_IS_CAREER_TEST_COMPLETED);

			response = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<Boolean>>() {},params);
			if (response.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_INVOKING,
						response.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_INVOKING
						+ response.getStatusCode().value());
			}

		} catch (InvokeException e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw e;
		} 
		catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return response.getBody().getData();
	}
	
	public void updateProcedureIdInCourse(String procedureId,String studentType, List<String> courseIds) {
		ResponseEntity<GenericWrapperDto<String>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(UPDATE_PROCEDURE_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			courseIds.stream().forEach(e -> uriBuilder.queryParam("course_ids", e));
			uriBuilder.queryParam("procedure_id", procedureId);
			uriBuilder.queryParam("student_type", studentType);

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.PUT, null,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
	}
	public void updateProcedureIdInCourseByInstituteId(String procedureId,String studentType, String instituteId) {
		ResponseEntity<GenericWrapperDto<String>> responseEntity = null;
		try {
			StringBuilder path = new StringBuilder();
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(UPDATE_PROCEDURE_ID).append(UPDATE_PROCEDURE_ID_BY_INSITUTE_ID);

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(path.toString());
			uriBuilder.queryParam("student_type", studentType);
			uriBuilder.queryParam("procedure_id", procedureId);
			uriBuilder.queryParam("institute_id", instituteId);

			responseEntity = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.PUT, null,
					new ParameterizedTypeReference<GenericWrapperDto<String>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
	}
	
	public InstituteRequestDto getInstituteDetailInfo(String userId, String instituteId) {
		ResponseEntity<GenericWrapperDto<InstituteRequestDto>> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(USER_ID, userId);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			Map<String, String> params = new HashMap<>();
			params.put("instituteId", instituteId);
			StringBuilder path = new StringBuilder();
			
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_INSTITUTE_DETAIL_INFO_BY_ID);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<InstituteRequestDto>>() {}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}

	public LevelDto getLevelById(String levelId) {
		ResponseEntity<GenericWrapperDto<LevelDto>> responseEntity = null;
		try {
			Map<String, String> params = new HashMap<>();
			params.put("levelId", levelId);
			StringBuilder path = new StringBuilder();
			
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_LEVEL_BY_ID);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
					new ParameterizedTypeReference<GenericWrapperDto<LevelDto>>() {}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public EducationSystemDto getEducationSystemById(String systemId) {
		ResponseEntity<GenericWrapperDto<EducationSystemDto>> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("",headers);
			
			Map<String, String> params = new HashMap<>();
			params.put("systemId", systemId);
			StringBuilder path = new StringBuilder();
			
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(GET_EDUCATION_SYSTEM_BY_ID);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, entity,
					new ParameterizedTypeReference<GenericWrapperDto<EducationSystemDto>>() {}, params);
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
	
	public Double calculateGrade(GradeDto gradeDto) {
		ResponseEntity<GenericWrapperDto<Double>> responseEntity = null;
		try {
		
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<GradeDto> entity = new HttpEntity<>(gradeDto, headers);
			
			StringBuilder path = new StringBuilder();
			
			path.append(IConstant.INSTITUTE_CONNECTION_URL).append(CALCULATE_GRADE);
			responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, entity,
					new ParameterizedTypeReference<GenericWrapperDto<Double>>() {});
			if (responseEntity.getStatusCode().value() != 200) {
				log.error(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
				throw new InvokeException(MSG_ERROR_CODE
						+ responseEntity.getStatusCode().value());
			}
		} catch (InvokeException e) {
			throw e;
		} catch (Exception e) {
			log.error(MSG_ERROR_INVOKING, e);
			throw new InvokeException(MSG_ERROR_INVOKING);
		}
		return responseEntity.getBody().getData();
	}
}
