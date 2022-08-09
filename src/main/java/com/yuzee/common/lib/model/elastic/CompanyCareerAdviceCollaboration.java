package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCareerAdviceCollaboration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1506289549779021818L;

	@Field(name = "id")
	private String id;

	@Field(name = "user_id")
	private String userId;

}
