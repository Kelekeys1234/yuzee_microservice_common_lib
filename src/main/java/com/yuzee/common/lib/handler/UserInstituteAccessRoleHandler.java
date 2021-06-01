package com.yuzee.common.lib.handler;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.yuzee.common.lib.dto.identity.UserInstituteAccessInternalResponseDto;
import com.yuzee.common.lib.exception.NotImplementedException;

import lombok.extern.slf4j.Slf4j;

@Component
@ConditionalOnProperty(name = "yuzee.userinstituteaccessrole-handler.enabled", havingValue = "true")
@Slf4j
public class UserInstituteAccessRoleHandler {

	public List<UserInstituteAccessInternalResponseDto> getUserInstituteAccessInternal(String instituteId,
			String status) throws NotImplementedException {
		log.error("Managing Institute Access is not yet implemented!!");
		throw new NotImplementedException("Managing Institute Accesss is not yet implemented!!");
	}

}
