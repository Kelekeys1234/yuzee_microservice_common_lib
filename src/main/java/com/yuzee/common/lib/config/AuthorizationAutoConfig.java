package com.yuzee.common.lib.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StreamUtils;

import com.yuzee.common.lib.dto.authorization.AuthorizationConfigDto;
import com.yuzee.common.lib.exception.InvokeException;
import com.yuzee.common.lib.handler.AuthorizationHandler;
import com.yuzee.common.lib.util.ObjectMapperHelper;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@ConditionalOnProperty(name = "authorization.config.file")
public class AuthorizationAutoConfig {
	
	@Autowired
	private AuthorizationHandler authorizationProvisioningHandler;
	
	@Value("${authorization.config.file}")
	private String provisioningConfigFilePath;
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() throws InvokeException, IOException {
		InputStream inputStream = new ClassPathResource(provisioningConfigFilePath).getInputStream();
		String config = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		log.info("config = {}",config);
		AuthorizationConfigDto authorizationConfigDto = ObjectMapperHelper.readValueFromJSON(config, AuthorizationConfigDto.class);
		
		log.info("creating scopes {}",authorizationConfigDto.getScopes());
		if(!ObjectUtils.isEmpty(authorizationConfigDto.getScopes())) {
			authorizationProvisioningHandler.createOrUpdateScopes(authorizationConfigDto.getScopes());			
		}
		
		log.info("creating role based policies {}",authorizationConfigDto.getRoleBasedPolicies());
		if(!ObjectUtils.isEmpty(authorizationConfigDto.getRoleBasedPolicies())) {
			authorizationProvisioningHandler.createOrUpdateRoleBasedPolicies(authorizationConfigDto.getRoleBasedPolicies());			
		}
		
		log.info("creating resources {}",authorizationConfigDto.getResources());
		if(!ObjectUtils.isEmpty(authorizationConfigDto.getResources())) {
			authorizationProvisioningHandler.createOrUpdateResources(authorizationConfigDto.getResources());			
		}
		
		log.info("creating permissions {}",authorizationConfigDto.getPermissions());
		if(!ObjectUtils.isEmpty(authorizationConfigDto.getPermissions())) {
			authorizationProvisioningHandler.createOrUpdateResourcePermissions(authorizationConfigDto.getPermissions());				
		}
	}
}
