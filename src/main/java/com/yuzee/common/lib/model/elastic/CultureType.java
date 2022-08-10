package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CultureType implements Serializable {
	private static final long serialVersionUID = -2363157497224023828L;

	@Field(name = "id")
	private String id;

	@Field(name = "name")
	private String name;

	@Field(name = "description")
	private String description;

	@Field(name = "also_known_as")
	private String alsoKnownAs;

	@Field(name = "qualities")
	private String qualities;

	@Field(name = "main_values")
	private String mainValues;

	@Field(name = "leadership_characteristics")
	private String leadershipCharacteristics;

	@Field(name = "motto")
	private String motto;

	@Field(name = "about")
	private String about;

	@Field(name = "benefits")
	private String benefits;

	@Field(name = "drawbacks")
	private String drawbacks;

	@Field(name = "commonly_found_in")
	private String commonFoundIn;

	@Field(name = "examples")
	private String examples;

	@Field(name = "cultureType", type = FieldType.Nested)
	private List<SubCultureType> subCultureTypes = new ArrayList<>();
}