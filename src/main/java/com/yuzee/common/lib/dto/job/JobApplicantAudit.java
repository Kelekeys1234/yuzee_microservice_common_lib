package com.yuzee.common.lib.dto.job;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JobApplicantAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1587261843956006830L;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("comment_text")
	private String commentText;
}