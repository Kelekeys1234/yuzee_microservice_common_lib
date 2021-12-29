package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.institute.CourseContactPersonDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("id")
	@Field("id")
	private String id;
	
	@JsonProperty("name")
	@Field("name")
	private String name;

	@JsonProperty("faculty")
	@Field("faculty")
	private Faculty faculty;

	@JsonProperty("institute")
	@Field("institute")
	private Institute institute;

	@JsonProperty("level")
	@Field("level")
	private Level level;

	@JsonProperty("course_curriculum")
	@Field("course_curriculum")
	private CourseCurriculum courseCurriculum;

	@JsonProperty("world_ranking")
	@Field("world_ranking")
	private Integer worldRanking;

	@JsonProperty("stars")
	@Field("stars")
	private Integer stars;

	@JsonProperty("recognition")
	@Field("recognition")
	private String recognition;

	@JsonProperty("recognition_type")
	@Field("recognition_type")
	private String recognitionType;

	@JsonProperty("abbreviation")
	@Field("abbreviation")
	private String abbreviation;

	@JsonProperty("remarks")
	@Field("remarks")
	private String remarks;

	@JsonProperty("description")
	@Field("description")
	private String description;

	@JsonProperty("availabilty")
	@Field("availabilty")
	private String availabilty;

	@JsonProperty("currency")
	@Field("currency")
	private String currency;

	@JsonProperty("currency_time")
	@Field("currency_time")
	private String currencyTime;

	@JsonProperty("global_gpa")
	@Field("global_gpa")
	private Double globalGpa;

	@JsonProperty("rec_date")
	@Field("rec_date")
	private Date recDate;

	@JsonProperty("content")
	@Field("content")
	private String content;

	@JsonProperty("examination_board")
	@Field("examination_board")
	private String examinationBoard;

	@JsonProperty("domestic_application_fee")
	@Field("domestic_application_fee")
	private Double domesticApplicationFee;

	@JsonProperty("international_application_fee")
	@Field("international_application_fee")
	private Double internationalApplicationFee;

	@JsonProperty("domestic_enrollment_fee")
	@Field("domestic_enrollment_fee")
	private Double domesticEnrollmentFee;

	@JsonProperty("international_enrollment_fee")
	@Field("international_enrollment_fee")
	private Double internationalEnrollmentFee;

	@JsonProperty("usd_domestic_application_fee")
	@Field("usd_domestic_application_fee")
	private Double usdDomesticApplicationFee;

	@JsonProperty("usd_international_application_fee")
	@Field("usd_international_application_fee")
	private Double usdInternationalApplicationFee;

	@JsonProperty("usd_domestic_enrollment_fee")
	@Field("usd_domestic_enrollment_fee")
	private Double usdDomesticEnrollmentFee;

	@JsonProperty("usd_international_enrollment_fee")
	@Field("usd_international_enrollment_fee")
	private Double usdInternationalEnrollmentFee;

	@JsonProperty("entrance_exam")
	@Field("entrance_exam")
	private String entranceExam;

	@JsonProperty("code")
	@Field("code")
	private String code;

	@JsonProperty("course_type")
	@Field("course_type")
	private String courseType;

	@JsonProperty("off_campus_course")
	@Field("off_campus_course")
	private OffCampusCourse offCampusCourse;

	@JsonProperty("course_payment")
	@Field("course_payment")
	private CoursePayment coursePayment;

	@JsonProperty("course_delivery_modes")
	@Field("course_delivery_modes")
	private List<CourseDeliveryMode> courseDeliveryModes;

	@JsonProperty("course_english_eligibilities")
	@Field("course_english_eligibilities")
	private List<CourseEnglishEligibility> courseEnglishEligibilities;

	@JsonProperty("course_intake")
	@Field("course_intake")
	private CourseIntake courseIntake;

	@JsonProperty("course_languages")
	@Field("course_languages")
	private List<String> languages;

	@JsonProperty("course_min_requirements")
	@Field("course_min_requirements")
	private List<CourseMinRequirement> courseMinRequirements;

	@JsonProperty("course_prerequisites")
	@Field("course_prerequisites")
	private List<CoursePreresquisite> coursePrerequisites;

	@JsonProperty("course_career_outcomes")
	@Field("course_career_outcomes")
	private List<CourseCareerOutcome> courseCareerOutcomes;

	@JsonProperty("course_subjects")
	@Field("course_subjects")
	private List<CourseSubject> courseSubjects;

	@JsonProperty("course_fundings")
	@Field("course_fundings")
	private List<CourseFunding> courseFundings;
	
	@JsonProperty("contact_details")
	@Field(name = "contact_details", type = FieldType.Nested)
	private List<ContactDetail> contactDetails = new ArrayList<>();
	
	@JsonProperty("course_timings")
	@Field("course_timings")
	private List<Timing> courseTimings = new ArrayList<>();
	
	@JsonProperty("is_active")
	@Field(name = "is_active")
	private Boolean isActive;

	@JsonProperty("readable_id")
	@Field(name = "readable_id")
	private String readableId;
	
	@JsonProperty("international_student_procedure_id")
	@Field("international_student_procedure_id")
	private String internationalStudentProcedureId;
	
	@JsonProperty("domestic_student_procedure_id")
	@Field("domestic_student_procedure_id")
	private String domesticStudentProcedureId;
	
	@JsonProperty("course_contact_person")
	private List<CourseContactPersonDto> CourseContactPersons;
	
	@JsonProperty("provider_codes")
	@Field(name = "provider_codes", type = FieldType.Nested)
	private List<ProviderCode> providerCodes = new ArrayList<>();
}
