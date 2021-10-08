package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseEnglishEligibility implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("course_eligibility_id")
	@Field("course_eligibility_id")
	private String id;
	
	@JsonProperty("english_type")
	@Field("english_type")
	@NotEmpty(message = "english_type should not be blank")
	private String englishType;
	
	@JsonProperty("reading")
	@Field("reading")
	private Double reading;
	
	@JsonProperty("writing")
	@Field("writing")
	private Double writing;
	
	@JsonProperty("speaking")
	@Field("speaking")
	private Double speaking;
	
	@JsonProperty("listening")
	@Field("listening")
	private Double listening;
	
	@JsonProperty("overall")
	@Field("overall")
	private Double overall;
}
