package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApplicationFamilyMemberDto implements Serializable {
	
	private static final long serialVersionUID = 3935914102224763183L;
	
	@JsonProperty("id")
	private UUID _id;
	
	@NotBlank(message = "{user_application.family_member.family_member_account_type.is_required}") 
	@JsonProperty("family_member_account_type")
	private String familyMemberAccountType;
	
	@NotBlank(message = "{user_application.family_member.family_member_user_id.is_required}") 
	@JsonProperty("family_member_user_id")
	private String familyMemberUserId;
	
	@JsonProperty("parent_user_id")
	private String parentUserId;
}

