package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserApplicationOtherDetailsDto implements Serializable {
	
	private static final long serialVersionUID = -5102056077428218275L;
	
	@JsonProperty(value = "other_details")
	private UUID _id;
	
	@NotNull(message = "{user_application.date_of_issue.is_required}") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("date_of_issue")
	private Date dateOfIssue;

	@NotNull(message = "{user_application.date_of_expiry.is_required}") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("date_of_expiry")
	private Date dateOfExpiry;
	
	@NotNull(message = "{user_application.passport_number.is_required}")
	@JsonProperty("passport_number")
	private String passportNumber; 
	
	@NotNull(message = "{user_application.home_address.is_required}")
	@JsonProperty("home_address")
	private String homeAddress;
	
	@NotNull(message = "{user_application.mailing_address.is_required}")
	@JsonProperty("mailing_address")
	private String mailingAddress;

}
