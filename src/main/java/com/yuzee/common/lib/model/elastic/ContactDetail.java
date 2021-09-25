
package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7351584066595388761L;

	@JsonProperty("contact_detail_id")
	@Field(name = "id")
	private String id;

	@JsonProperty("contact_type")
	@Field(name = "contact_type")
	private String contactType;

	@JsonProperty("value")
	@Field(name = "value")
	private String value;
}
