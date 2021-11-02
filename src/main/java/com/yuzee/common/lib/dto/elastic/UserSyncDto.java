package com.yuzee.common.lib.dto.elastic;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.company.CompanyContactDetailDto;
import com.yuzee.common.lib.dto.connection.NetworkDto;
import com.yuzee.common.lib.dto.institute.SyncDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSyncDto implements SyncDTO {

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

	@JsonProperty("email")
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

	@JsonProperty("credentials_expired")
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

	@JsonProperty("user_interested_fields")
	private List<String> fields;

	@JsonProperty("user_skills")
	private List<String> skills;

	@JsonProperty("user_interests")
	private List<String> interest;

	@JsonProperty("user_interested_country")
	private List<String> userInterestedCountries;

	@JsonProperty("user_reachout_info")
	private List<String> userReachOutInfo;
	
	@JsonProperty("connections")
	private List<NetworkDto> connections;
	
	@JsonProperty("followings")
	private List<NetworkDto> followings;

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

	@JsonProperty("contact_details")
	private List<CompanyContactDetailDto> contactDetails;

	@JsonProperty("profile_picture_path")
	private String profilePicturePath;

	@Override
	public String getIdentifier() {
		return this.getId();
	}
	
	@JsonProperty("verified")
	private boolean verified;
	
	@JsonProperty("designation")
	private String designation;

	public UserSyncDto(String id, String privacyLevel, String firstName, String middleName, String lastName,
			String readableId, String gender, String dob, String countryOrgin, String citizenship, String email,
			String username, String mobileNo, String skypeId, String userEduInfo, Boolean status, String signUpType,
			String socialAccountId, String userType, boolean enabled, boolean accountExpired,
			boolean credentialsExpired, boolean accountLocked, String whattsappNo, String city, String state,
			String postalCode, String homeAddress, String mailingAddress, String aboutMe, String passportNo,
			Date passportExpiryDate, Date passportIssueDate, String currencyCode, String imageName,
			UserFutureMeElasticDto userFutureMe, List<String> hobbies, List<String> fields, List<String> skills,
			List<String> interest, List<String> userInterestedCountries, List<String> userReachOutInfo,
			List<UserAchivementsElasticDto> userAchivements, List<UserEducationElasticDto> userEducation,
			List<UserWorkExperienceElasticDto> userWorkExperience,
			List<UserLanguageQualificationElasticDto> userLanguageQualifications,
			List<UserExtenededContactElasticDto> userExtendedContacts,
			List<UserAccomplishmentElasticDto> userAccomplishment, List<CompanyContactDetailDto> contactDetails,
			String profilePicturePath) {
		super();
		this.id = id;
		this.privacyLevel = privacyLevel;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.readableId = readableId;
		this.gender = gender;
		this.dob = dob;
		this.countryOrgin = countryOrgin;
		this.citizenship = citizenship;
		this.email = email;
		this.username = username;
		this.mobileNo = mobileNo;
		this.skypeId = skypeId;
		this.userEduInfo = userEduInfo;
		this.status = status;
		this.signUpType = signUpType;
		this.socialAccountId = socialAccountId;
		this.userType = userType;
		this.enabled = enabled;
		this.accountExpired = accountExpired;
		this.credentialsExpired = credentialsExpired;
		this.accountLocked = accountLocked;
		this.whattsappNo = whattsappNo;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.homeAddress = homeAddress;
		this.mailingAddress = mailingAddress;
		this.aboutMe = aboutMe;
		this.passportNo = passportNo;
		this.passportExpiryDate = passportExpiryDate;
		this.passportIssueDate = passportIssueDate;
		this.currencyCode = currencyCode;
		this.imageName = imageName;
		this.userFutureMe = userFutureMe;
		this.hobbies = hobbies;
		this.fields = fields;
		this.skills = skills;
		this.interest = interest;
		this.userInterestedCountries = userInterestedCountries;
		this.userReachOutInfo = userReachOutInfo;
		this.userAchivements = userAchivements;
		this.userEducation = userEducation;
		this.userWorkExperience = userWorkExperience;
		this.userLanguageQualifications = userLanguageQualifications;
		this.userExtendedContacts = userExtendedContacts;
		this.userAccomplishment = userAccomplishment;
		this.contactDetails = contactDetails;
		this.profilePicturePath = profilePicturePath;
	}

	

}
