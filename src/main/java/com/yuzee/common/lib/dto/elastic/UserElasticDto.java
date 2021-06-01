package com.yuzee.common.lib.dto.elastic;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserElasticDto {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("middle_name")
	private String middleName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("readable_id")
	private String readableId;

	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("dob")
	private String dob;
	
	@JsonProperty("country_orgin")
	private String countryOrgin;
	
	@JsonProperty("citizenship")
	private String citizenship;
	
	@JsonProperty( "email")
	private String email;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("mobile_no")
	private String mobileNo;

	@JsonProperty("skype_id")
	private String skypeId;
	
	@JsonProperty("user_edu_info")
	private String userEduInfo;
	
	@JsonProperty("status")
	private Boolean status;
	
	@JsonProperty("sign_up_type")
	private String signUpType;
	
	@JsonProperty("social_account_id")
	private String socialAccountId;
	
	@JsonProperty("user_type")
	private String userType;

	@JsonProperty("enabled")
	private boolean enabled;

	@JsonProperty("account_expired")
	private boolean accountExpired;

	@JsonProperty("credentials_expired" )
	private boolean credentialsExpired;

	@JsonProperty("account_locked")
	private boolean accountLocked;

	@JsonProperty("whattsapp_no")
	private String whattsappNo;

	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("postal_code")
	private String postalCode;
	
	@JsonProperty("home_address")
	private String homeAddress;
	
	@JsonProperty("mailing_address")
	private String mailingAddress;
	
	@JsonProperty("about_me")
	private String aboutMe;
	
	@JsonProperty("passport_no")
	private String passportNo;
	
	@JsonProperty("passport_expiry_date")
	private Date passportExpiryDate;
	
	@JsonProperty("passport_issue_date")
	private Date passportIssueDate;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	
	@JsonProperty("image_name")
	private String imageName;
		
	@JsonProperty("user_future_me")
	private UserFutureMeElasticDto userFutureMe;
	
	@JsonProperty("user_hobbies")
	private List<String> hobbies;
	
	@JsonProperty("user_fields")
	private List<String> fields ;

	@JsonProperty("user_skills")
	private List<String> skills;
	
	@JsonProperty("user_interests")
	private List<String> interest;
	
	@JsonProperty("user_interested_country")
	private List<String> userInterestedCountries;
	
	@JsonProperty("user_reachout_info")
	private List<String> userReachOutInfo;
	
	@JsonProperty("connections")
	private List<String> connections;
	
	@JsonProperty("followers")
	private List<String> followers;
	
	@JsonProperty("user_achievements")
	private List<UserAchivementsElasticDto> userAchivements;
	
	@JsonProperty("user_educations")
	private List<UserEducationElasticDto> userEducation;
	
	@JsonProperty("user_work_experiences")
	private List<UserWorkExperienceElasticDto> userWorkExperience;

	@JsonProperty("user_language_qualifications")
	private List<UserLanguageQualificationElasticDto> userLanguageQualifications;
	
	@JsonProperty("user_extended_contacts")
	private List<UserExtenededContactElasticDto> userExtendedContacts;
	
	@JsonProperty("user_accomplishment")
	private List<UserAccomplishmentElasticDto> userAccomplishment;
	
}
