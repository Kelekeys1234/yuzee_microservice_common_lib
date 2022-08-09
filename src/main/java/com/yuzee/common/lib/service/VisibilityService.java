package com.yuzee.common.lib.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.yuzee.common.lib.enumeration.ConnectionEntityType;
import com.yuzee.common.lib.enumeration.PrivacyLevelEnum;
import com.yuzee.common.lib.handler.ConnectionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@ConditionalOnProperty(name = "yuzee.visibility-service.enabled", havingValue = "true")
public class VisibilityService {
	
	@Autowired
	private ConnectionHandler connectionHandler;

	public List<PrivacyLevelEnum> getListOfPrivacyLevelForEntity(String entityId , ConnectionEntityType entityType , String requestedEntityId , ConnectionEntityType requestedEntityType) {
		List<PrivacyLevelEnum> privacyLevelEnums = new ArrayList<>();
		
		if (entityType.equals(ConnectionEntityType.COMPANY)) {
			privacyLevelEnums = Arrays.asList(PrivacyLevelEnum.PUBLIC,PrivacyLevelEnum.COMPANIES_ONLY,PrivacyLevelEnum.INSTITUTIONS_AND_COMPANIES);
		} 
		
		if (entityType.equals(ConnectionEntityType.INSTITUTE)) {
			privacyLevelEnums = Arrays.asList(PrivacyLevelEnum.PUBLIC,PrivacyLevelEnum.INSTITUTIONS_ONLY,PrivacyLevelEnum.INSTITUTIONS_AND_COMPANIES);
		} 
		
		if (entityType.equals(ConnectionEntityType.USER)) {
			privacyLevelEnums = Arrays.asList(PrivacyLevelEnum.PUBLIC,PrivacyLevelEnum.COMPANIES_ONLY,PrivacyLevelEnum.INSTITUTIONS_AND_COMPANIES);
		} 
		
		if (!org.apache.commons.lang.StringUtils.isEmpty(requestedEntityId) && !ObjectUtils.isEmpty(requestedEntityType) ) {
			log.info("Checking if user link exsist between requester user id {} and requested user id {}",entityId,requestedEntityId);
//			boolean linkExsists = connectionHandler.checkLinkExists(entityId, entityType.name(), requestedEntityId, requestedEntityType.name());
//			if (linkExsists) {
//				privacyLevelEnums.add(PrivacyLevelEnum.FOLLOWERS_ONLY);
//			}
		}
		
		if (requestedEntityId.equals(entityId)) {
			privacyLevelEnums.add(PrivacyLevelEnum.PRIVATE);
		}
		
		return privacyLevelEnums;
	}
}
