package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.connection.NetworkDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("user")
public class User implements Serializable {
	
	private static final long serialVersionUID = -6751446324629984248L;

	@Id
	@JsonProperty("id")
	@Field(name = "id")
	private String id;
	
	@Field(name = "privacy_level")
	@JsonProperty("privacy_level")
	private String privacyLevel;
	
	@Field(name = "first_name")
	@JsonProperty("first_name")
	private String firstName;
	
	@Field(name = "middle_name")
	@JsonProperty("middle_name")
	private String middleName;
	
	@Field(name = "last_name")
	@JsonProperty("last_name")
	private String lastName;

	@Field(name = "readable_id")
	@JsonProperty("readableId")
	private String readableId;
	
	@Field(name = "gender")
	@JsonProperty("gender")
	private String gender;
	
	@Field(name = "dob", type = FieldType.Date, store = true, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	@JsonProperty("dob")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private LocalDate dob;
	
	@Field(name = "country_orgin")
	@JsonProperty("country_orgin")
	private String countryOrgin;
	
	@Field(name = "citizenship")
	@JsonProperty("citizenship")
	private String citizenship;
	
	@Field(name = "email")
	@JsonProperty( "email")
	private String email;
	
	@Field(name = "username")
	@JsonProperty("username")
	private String username;
	
	@Field(name = "password")
	@JsonProperty("password")
	private String password;
	
	@Field(name = "mobile_no")
	@JsonProperty("mobile_no")
	private String mobileNo;

	@Field(name = "skype_id")
	@JsonProperty("skype_id")
	private String skypeId;
	
	@Field(name = "user_edu_info")
	@JsonProperty("user_edu_info")
	private String userEduInfo;
	
	@Field(name = "status")
	@JsonProperty("status")
	private Boolean status;
	
	@Field(name = "dob_str")
	@JsonProperty("dob_str")
	private String dobStr;
	
	@Field(name = "sign_up_type")
	@JsonProperty("sign_up_type")
	private String signUpType;
	
	@Field(name = "social_account_id")
	@JsonProperty("social_account_id")
	private String socialAccountId;
	
	@Field(name = "user_type")
	@JsonProperty("user_type")
	private String userType;

	@Field(name = "enabled")
	@JsonProperty("enabled")
	private boolean enabled;

	@Field(name = "account_expired")
	@JsonProperty("account_expired")
	private boolean accountExpired;

	@Field(name = "credentials_expired")
	@JsonProperty("credentials_expired" )
	private boolean credentialsExpired;

	@Field(name = "account_locked")
	@JsonProperty("account_locked")
	private boolean accountLocked;

	@Field(name = "whattsapp_no")
	@JsonProperty("whattsapp_no")
	private String whattsappNo;

	@Field(name = "city")
	@JsonProperty("city")
	private String city;
	
	@Field(name = "state")
	@JsonProperty("state")
	private String state;
	
	@Field(name = "postal_code")
	@JsonProperty("postal_code")
	private String postalCode;
	
	@Field(name = "home_address")
	@JsonProperty("home_address")
	private String homeAddress;
	
	@Field(name = "mailing_address")
	@JsonProperty("mailing_address")
	private String mailingAddress;
	
	@Field(name = "about_me")
	@JsonProperty("about_me")
	private String aboutMe;
	
	@Field(name = "passport_no")
	@JsonProperty("passport_no")
	private String passportNo;
	
	@Field(name = "passport_expiry_date")
	@JsonProperty("passport_expiry_date")
	private Date passportExpiryDate;
	
	@Field(name = "passport_issue_date")
	@JsonProperty("passport_issue_date")
	private Date passportIssueDate;
	
	@Field(name = "currency_code")
	@JsonProperty("currency_code")
	private String currencyCode;
	
	@Field(name = "image_name")
	@JsonProperty("image_name")
	private String imageName;
	
	@Field(name = "designation")
	@JsonProperty("designation")
	private String designation;
		
	@Field(name = "user_future_me")
	@JsonProperty("user_future_me")
	private UserFutureMeElasticDto userFutureMe;
	
	@Field(name = "user_hobbies")
	@JsonProperty("user_hobbies")
	private List<String> hobbies;
	
	@Field(name = "user_interested_fields")
	@JsonProperty("user_interested_fields")
	private List<String> fields;

	@Field(name = "user_skills")
	@JsonProperty("user_skills")
	private List<String> skills;
	
	@Field(name = "user_interests")
	@JsonProperty("user_interests")
	private List<String> interest;
	
	@Field(name = "connections", type = FieldType.Nested)
	@JsonProperty("connections")
	private List<NetworkDto> connections = null;
	
	@Field(name = "followings", type = FieldType.Nested)
	@JsonProperty("followings")
	private List<NetworkDto> followings = null;
	
	@Field(name = "user_achievements")
	@JsonProperty("user_achievements")
	private List<UserAchivementsElasticDto> userAchivements = new ArrayList<>();
	
	@Field(name = "user_educations", type = FieldType.Nested)
	@JsonProperty("user_educations")
	private List<UserEducationElasticDto> userEducation = new ArrayList<>();
	
	@Field(name = "user_work_experiences", type = FieldType.Nested)
	@JsonProperty("user_work_experiences")
	private List<UserWorkExperienceElasticDto> userWorkExperience = null;
	
	@Field(name = "user_interested_country")
	@JsonProperty("user_interested_country")
	private List<String> userInterestedCountries = null;
	
	@Field(name = "user_language_qualifications")
	@JsonProperty("user_language_qualifications")
	private List<UserLanguageQualificationElasticDto> userLanguageQualifications = null;
	
	@JsonProperty("contact_details")
	@Field(name = "contact_details", type = FieldType.Nested)
	private List<ContactDetail> contactDetails = new ArrayList<>();
	
	@Field(name = "user_reachout_info")
	@JsonProperty("user_reachout_info")
	private List<String> userReachOutInfo = null;
	
	@Field(name = "user_accomplishment")
	@JsonProperty("user_accomplishment")
	private List<UserAccomplishmentElasticDto> userAccomplishment = null;
	
}
