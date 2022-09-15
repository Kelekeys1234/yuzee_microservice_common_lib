package com.yuzee.common.lib.handler;

import com.yuzee.common.lib.constants.IConstant;
import com.yuzee.common.lib.dto.CountDto;
import com.yuzee.common.lib.dto.GenericWrapperDto;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@ConditionalOnProperty(name = "yuzee.scholarship-handler.enabled", havingValue = "true")
public class ScholarshipHandler {

    @Autowired
    private RestTemplate restTemplate;
    private static final String GET_SCHOLARSHIP_COUNT_BY_ENTITYID_AND_ENTITYTYPE = "/scholarship/count/entityId/{entityId}/entityType/{entityType}";

    private static final String MSG_ERROR_CODE = "Error response recieved from scholarship service with error code ";

    private static final String MSG_ERROR_INVOKE_SERVICE = "Error invoking scholarship service";


    public CountDto getScholarshipCountByEntityIdAndEntityType(final String entityId, final String entityType) {
        ResponseEntity<GenericWrapperDto<CountDto>> responseEntity = null;
        Map<String, String> params = new HashMap<>();
        try {
            params.put("entityId", entityId);
            params.put("entityType", entityType);
            StringBuilder path = new StringBuilder();
            path.append(IConstant.SCHOLARSHIP_URL).append(GET_SCHOLARSHIP_COUNT_BY_ENTITYID_AND_ENTITYTYPE);
            responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<GenericWrapperDto<CountDto>>() {
                    }, params);
            if (responseEntity.getStatusCode().value() != 200) {
                log.error(MSG_ERROR_CODE
                        + responseEntity.getStatusCode().value());
                throw new InvokeException(MSG_ERROR_CODE
                        + responseEntity.getStatusCode().value());
            }
        } catch (InvokeException | NotFoundException e) {
            log.error(MSG_ERROR_INVOKE_SERVICE, e);
            throw e;
        } catch (Exception e) {
            log.error(MSG_ERROR_INVOKE_SERVICE, e);
            throw new InvokeException(MSG_ERROR_INVOKE_SERVICE);
        }
        return responseEntity.getBody().getData();
    }
}
