package com.yuzee.common.lib.model.elastic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "yuzee_dev_alias")
@TypeAlias("company")
public class Company implements Serializable {
	private static final long serialVersionUID = 6680304362302742436L;

	@Id
	@JsonProperty("id")
	@Field(name = "id")
	private String id;

	@JsonProperty("privacy_level")
	@Field(name = "privacy_level")
	private String privacyLevel;

	@JsonProperty("is_verified")
	@Field(name = "is_verified")
	public boolean isVerified = false;

	@JsonProperty("company_name")
	@Field(name = "company_name")
	private String companyName;

	@JsonProperty("readable_id")
	@Field(name = "readable_id")
	private String readableId;

	@JsonProperty("tag_line")
	@Field(name = "tag_line")
	private String tagLine;

	@JsonProperty("about_us")
	@Field(name = "about_us")
	private String aboutUs;

	@JsonProperty("industry")
	@Field(name = "industry")
	private String industry;

	@JsonProperty("website_url")
	@Field(name = "website_url")
	private String websiteUrl;

	@JsonProperty("company_type")
	@Field(name = "company_type")
	private String companyType;

	@JsonProperty("industry_type")
	@Field(name = "industry_type")
	private String industryType;

	@JsonProperty("year_founder")
	@Field(name = "year_founder")
	private Integer yearFounder;

	@JsonProperty("is_active")
	@Field(name = "is_active")
	public Boolean isActive = true;

	@JsonProperty("company_partner_primary_detail")
	@Field(name = "company_partner_primary_detail", type = FieldType.Nested)
	private CompanyPartnerPrimaryDetail companyPartnerPrimaryDetail;

	@JsonProperty("company_speciality")
	@Field(name = "company_speciality", type = FieldType.Nested)
	private List<CompanySpeciality> listOfCompanySpeciality = new ArrayList<>();

	@JsonProperty("company_work_with_us")
	@Field(name = "company_work_with_us", type = FieldType.Nested)
	private List<CompanyWorkWithUs> listOfCompanyWorkWithUs = new ArrayList<>();

	@JsonProperty("company_location")
	@Field(name = "company_location", type = FieldType.Nested)
	private List<CompanyLocation> listOfCompanyLocation = new ArrayList<>();

	@JsonProperty("company_achievement")
	@Field(name = "company_achievement", type = FieldType.Nested)
	private List<CompanyAchievement> listOfCompanyAchievement = new ArrayList<>();

	@JsonProperty("company_award_and_certification")
	@Field(name = "company_award_and_certification", type = FieldType.Nested)
	private List<CompanyAwardAndCertification> listOfCompanyAwardAndCertification = new ArrayList<>();

	@JsonProperty("company_staff_interview")
	@Field(name = "company_staff_interview", type = FieldType.Nested)
	private List<CompanyStaffInterview> listOfCompanyStaffInterview = new ArrayList<>();

	@JsonProperty("company_career_advice")
	@Field(name = "company_career_advice", type = FieldType.Nested)
	private List<CompanyCareerAdvice> listOfCompanyCareerAdvice = new ArrayList<>();

	@JsonProperty("company_internship")
	@Field(name = "company_internship", type = FieldType.Nested)
	private List<CompanyInternship> listOfCompanyInternship = new ArrayList<>();

	@JsonProperty("company_working_hours")
	@Field(name = "company_working_hours", type = FieldType.Nested)
	private List<CompanyWorkingHours> listOfCompanyWorkingHours = new ArrayList<>();

	@JsonProperty("contact_details")
	@Field(name = "contact_details", type = FieldType.Nested)
	private List<ContactDetail> contactDetails = new ArrayList<>();
}