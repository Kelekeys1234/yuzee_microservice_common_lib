package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

@Data
public class JobApplicantAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1587261843956006830L;
	
	@Field(name = "id")
	private String id;
	
	@Field(name = "user_id")
	private String userId;
	
	@Field(name = "comment_text")
	private String commentText;
}