package com.yuzee.common.lib.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExampleVideoCategoryTypeEnum {
	BACKGROUND_AND_PERSONALITY("Background and personality","userIcon.svg",false),
	CREATIVITY("Creativity","creativity.svg",false),
	EMPATHY_AND_PATIENT_CARE("Empathy and patient care","care.svg",false),
	ETHICS("Ethics","ethics.svg",false),
	INTERESTS_AND_ENTHUSIASM("Interests and enthusiasm","interests.svg",false),
	KNOWLEDGE("Knwoledge","knowledge.svg",false),
	KNOWLEDGE_AND_TEACHING_METHODS("Knwoledge and teaching methods","teaching_method.svg",false),
	KNOWLEDGE_AND_WORK_EXPERIENCE("Knwoledge and work experience","work_exp.svg",false),
	PERFORMANCE("Performance","perfomance.svg",false),
	PROBLEM_SOLVING("Problem solving","problem_solving.svg",false),
	TEAMWORK("Teamwork","team_work.svg",false),
	WORK_EXPERIENCE("Work experience","workExp.svg",false);
	
	@Getter private String displayName;
	@Getter @Setter private String imageName;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Getter @Setter private boolean initialized;
	
	public String getName() {
		return this.name();
	}

}
