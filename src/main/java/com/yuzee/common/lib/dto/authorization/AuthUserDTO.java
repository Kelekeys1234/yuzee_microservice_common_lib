package com.yuzee.common.lib.dto.authorization;

import java.util.List;

import lombok.Data;

@Data
public class AuthUserDTO {
	
	private String userId;
	
	private String subject;
	
	private String userName;
	
	private String preferredUsername;
	
	private String givenName;
	
	private String middleName;
	
	private String familyName;
	
	private String email;
	
	private String password;
	
	private List<String> effectiveRoles;
	
	private boolean enabled;
}
