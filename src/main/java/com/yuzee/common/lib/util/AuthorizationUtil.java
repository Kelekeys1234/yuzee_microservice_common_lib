package com.yuzee.common.lib.util;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthorizationUtil {

//	@Autowired
//	private AccessibilityHandler accessibilityHandler;
//

	public void checkUserAccessEntityAuthorization(String entityId, String grantUserId, String subModuleName,
			String moduleName, String claim, String entityType) {

		// CheckUserAccessEntityDto checkUserAccessEntityDto =
		// accessibilityHandler.checkAccessibility(entityId,
//				grantUserId, moduleName, subModuleName, claim, entityType);
//		if (ObjectUtils.isEmpty(checkUserAccessEntityDto) || !checkUserAccessEntityDto.isAuthorized()) {
//			log.error("No User Access for entityId {} , grantUserId {} ", entityId, grantUserId);
//			throw new ForbiddenException("No User Access Found for entityId ");
		// }
	}
}
