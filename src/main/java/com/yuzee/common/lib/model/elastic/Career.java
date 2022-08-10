package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("career_id")
	@Field("career_id")
	private String id;

	@JsonProperty("career_name")
	@Field("career_name")
	private String career;

	@JsonProperty("job_ids")
	@Field("job_ids")
	private List<String> jobIds;
}
