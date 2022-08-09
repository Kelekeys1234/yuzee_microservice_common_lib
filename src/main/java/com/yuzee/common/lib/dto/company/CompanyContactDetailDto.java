package com.yuzee.common.lib.dto.company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyContactDetailDto {

	@JsonProperty("contact_detail_id")
	private String id;

	@NotBlank(message = "contact_type should not be null / blank")
	@JsonProperty("contact_type")
	private String contactType;

	@NotBlank(message = "value should not be null / blank")
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("icon")
	private String icon;
	
	@NotEmpty(message = "{privacy_level.is_required}")
	@JsonProperty("privacy_level")
	private String privacyLevel;

	public CompanyContactDetailDto(String id,
			@NotBlank(message = "contact_type should not be null / blank") String contactType,
			@NotBlank(message = "value should not be null / blank") String value, String icon) {
		super();
		this.id = id;
		this.contactType = contactType;
		this.value = value;
		this.icon = icon;
	}

}
