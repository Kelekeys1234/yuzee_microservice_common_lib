package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCulturePeople implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4424655877352159472L;
	
	@Field(name = "id")
	private String id;
	
	@Field(name = "user_id")
	private String userId;
}
