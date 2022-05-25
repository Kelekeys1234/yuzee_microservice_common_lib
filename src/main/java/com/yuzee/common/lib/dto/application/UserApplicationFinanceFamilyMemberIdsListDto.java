package com.yuzee.common.lib.dto.application;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserApplicationFinanceFamilyMemberIdsListDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{user_application.family_member.member_id.is_required}") 
	@JsonProperty("member_id")
	private String memberId;
}
