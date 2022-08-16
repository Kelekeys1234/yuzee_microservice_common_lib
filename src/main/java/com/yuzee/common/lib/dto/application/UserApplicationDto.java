package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yuzee.common.lib.dto.institute.InstituteDto;
import com.yuzee.common.lib.dto.storage.StorageDto;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@AllArgsConstructor
@NoArgsConstructor
public class UserApplicationDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private UUID _id;
	
	@JsonProperty("readable_id")
	private String readableId;

	@NotBlank(message = "{user_application.type.is_required}")
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("status")
	private String status;
	
	@Column(name = "parent_user_application_id")
	private String parentUserApplicationId;
	
	@JsonProperty("student_type")
	private String studentType;
	
	@JsonProperty("applicant_id")
	private String applicantId;
	
	@JsonProperty("applicant_details")
	private UserInitialInfoDto userInitialInfoDto;
	
	@JsonProperty("application_type")
	private String applicationType;
	
	@JsonProperty("education_details")
	private UserEducationDto userEducation;
	
	@JsonProperty("why_would_you_like_to_upskill")
	private String whyWouldYouLikeToUpsklll;
	
	@JsonProperty("currenly_working")
	private String currentlyWorking;
	
	@JsonProperty("study_time")
	private UserStudyTimeDto studyTime;
	
	@JsonProperty("course_id")
	private String courseId;
	
	@JsonProperty("course_name")
	private String courseName;

	@JsonProperty("institute_id")
	private String instituteId;
	
	@JsonProperty("institute_dto")
	private InstituteDto instituteDto = null;
	
	@NotBlank(message = "{user_application.applying_for_type.is_required}")
	@JsonProperty("applying_for_type")
	private String applyingForType;
	
	@JsonProperty("description_preferences")
	private String descriptionPreferences;
	
	@JsonProperty("delivery_mode")
	private Set<String> deliveryModes;
	
	@JsonProperty("study_mode")
	private Set<String> studyModes;
	
	@JsonProperty("levels")
	private Set<String> levels;
	
	@JsonProperty("why_interested")
	private String whyInterested;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("intake_date")
	private Set<Date> intakeDates;
	
	@Valid
	@JsonProperty("preffered_locations")
	private Set <UserApplicationLocationDto> preferredLocations = null;
	
	@JsonProperty("keywords")
	private Set <String> keywords;
	
	@JsonProperty("finance_details")
	private UserApplicationFinanceDetailsWapperDto financeDetails = null;
	
	@JsonProperty("scholarship")
	private UserApplicationScholarshipDto scholarship = null;
	
	@JsonProperty("other_requirements")
	private List<UserApplicationOtherRequirementRestInterfaceDto> otherRequirements = null;
	
	@JsonProperty("other_details")
	private UserApplicationOtherDetailsDto otherDetails = null;
	
	@JsonProperty("family_member_details")
	private UserApplicationFamilyMemberDto userApplicationFamilyMemberDto;
	
	@JsonProperty("member_parent_details")
	private UserApplicationMemberParentDetailsDto userApplicationMemberParentDetailsDto;
	
	@JsonProperty("video_pitch")
	private List<StorageDto> videoPitch = null;
	
	@Column(name = "procedure_id")
	private String procedureId;
	
	@JsonProperty("is_video_application")
	private boolean isVideoApplication;
	
	@JsonProperty("rejected_application")
	private UserApplicationRejectedDto userApplicationRejected = null;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_on")
	private Date createdOn;
	
	@JsonProperty("updated_by")
	private String updatedBy;
	
	@JsonProperty("updated_on")
	private Date updatedOn ;
	
	@JsonProperty(value = "offer_ids", access = Access.READ_ONLY)
	private List<String> offerIds;
	
	@JsonProperty(value = "draft_offer_ids", access = Access.READ_ONLY)
	private List<String> draftOfferIds;
	
	@JsonProperty(value = "offer_count", access = Access.READ_ONLY)
	private int offerCount;
	
}