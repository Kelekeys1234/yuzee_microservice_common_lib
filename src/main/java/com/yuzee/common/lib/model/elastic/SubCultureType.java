package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCultureType implements Serializable {
	private static final long serialVersionUID = -2363157497224023828L;

	@Id
	@Field(name = "id")
	private String id;

	@Field(name = "name")
	private String name;

	@Field(name = "description")
	private String description;
}