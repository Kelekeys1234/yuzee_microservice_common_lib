package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

@Data
public class ApplicantProfileSetting implements Serializable {

	private static final long serialVersionUID = -2905567554170894965L;
	
	@Field(name = "id")
	private String id;
	
	@Field(name = "attach_documentation")
	private boolean attachDocumentation;
	
	@Field(name = "attach_certification")
	private boolean attachCertification;
	
	@Field(name = "attach_Q_And_A")
	private boolean attachQAndA;
	
	@Field(name = "attach_contact_details")
	private boolean attachContactDetails;
}