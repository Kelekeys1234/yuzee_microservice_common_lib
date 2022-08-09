package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@Data
public class UserApplicationMemberParentDetailsDto implements Serializable{
	
	private static final long serialVersionUID = 5188759180221115100L;
	
	@JsonProperty("id")
	private UUID _id;
	
	@NotBlank(message = "{user_application.member_parent.type.is_required}") 
	@JsonProperty("type")
	private String type;
	
	@NotBlank(message = "{user_application.member_parent.first_name.is_required}") 
	@JsonProperty("first_name")
	private String firstName;
	
	@NotBlank(message = "{user_application.member_parent.last_name.is_required}") 
	@JsonProperty("last_name")
	private String lastName;
	
	@NotBlank(message = "{user_application.member_parent.location.is_required}") 
	@JsonProperty("location")
	private String location;
	
	@NotBlank(message = "{user_application.member_parent.postal_code.is_required}") 
	@JsonProperty("postal_code")
	private String postalCode;

	@JsonProperty("ic_or_passport_number")
	private StorageDto icOrPassortNumber;
	
	@JsonProperty("proof_of_guardianship")
	private StorageDto proofOfGuardianship;

}
