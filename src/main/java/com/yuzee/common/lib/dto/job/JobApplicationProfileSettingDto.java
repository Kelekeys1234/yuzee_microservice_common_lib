package com.yuzee.common.lib.dto.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationProfileSettingDto extends JobBasicInfo {
	
	@JsonProperty("job_id")
	private String jobId;
	
	@JsonProperty("user_info")
	private UserInitialInfoDto userInitialInfoDto;
	
	@JsonProperty("application_id")
	private String applicationId;
	
	@JsonProperty("attach_documentation")
	private boolean attachDocumentation;
	
	@JsonProperty("attach_certification")
	private boolean attachCertification;
	
	@JsonProperty("attach_Q_And_A")
	private boolean attachQAndA;
	
	@JsonProperty("attach_contact_details")
	private boolean attachContactDetails;
	
	public JobApplicationProfileSettingDto(String id, String title, String description, String type,
			String address, String city, String state, String country, Double latitude, Double longitude,
			String entityId , String entityType, String entityName, String logoUrl, String jobLocation) {
		super(id,title,description,type,address,city,state,country,latitude,longitude,entityId,entityType,entityName, logoUrl,jobLocation);
	}
	
}