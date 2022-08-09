package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyStaffInterview implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4726590128509160305L;
	
	@JsonProperty("company_staff_interview_id")
	@Field(name = "id")
	private String id;
	
	@JsonProperty("title")
	@Field(name = "title")
	private String title;
	
	@JsonProperty("description")
	@Field(name = "description")
	private String description;
	
	@JsonProperty("taged_interviewee")
	@Field(type = FieldType.Nested, name = "taged_interviewee")
	private List<String> tagedInterviewee = new ArrayList<>();
}