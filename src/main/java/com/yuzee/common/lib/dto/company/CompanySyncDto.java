package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.institute.SyncDTO;

import lombok.Data;

@Data
public class CompanySyncDto implements SyncDTO{
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("privacy_level")
	private String privacyLevel;

	@JsonProperty("is_verified")
	public boolean isVerified = false;
	
	@JsonProperty("company_name")
	private String companyName;
	
	@JsonProperty("readable_id")
	private String readableId;
	
	@JsonProperty("tag_line")
	private String tagLine;
	
	@JsonProperty("about_us")
	private String aboutUs;
	
	@JsonProperty("industry")
	private String industry;
	
	@JsonProperty("website_url")
	private String websiteUrl;
	
	@JsonProperty("company_type")
	private String companyType;
	
	@JsonProperty("industry_type")
	private String industryType;
	
	@JsonProperty("year_founder")
	private Integer yearFounder;
	
	@JsonProperty("is_active")
	public Boolean isActive = true;
		
	@JsonProperty("company_partner_primary_detail")
	private CompanyPartnerPrimaryDetailElasticDto companyPartnerPrimaryDetail;
		
	@JsonProperty("company_speciality")
	private List<CompanySpecialityDto> listOfCompanySpeciality = new ArrayList<>();

	@JsonProperty("company_work_with_us")
	private List<CompanyWorkWithUsElasticDto> listOfCompanyWorkWithUs = new ArrayList<>();
	
	@JsonProperty("company_location")
	private List<CompanyLocationDto> listOfCompanyLocation = new ArrayList<>();
	
	@JsonProperty("company_achievement")
	private List<CompanyAchievementElasticDto> listOfCompanyAchievement = new ArrayList<>();
	
	@JsonProperty("company_award_and_certification")
	private List<CompanyAwardAndCertificationDto> listOfCompanyAwardAndCertification = new ArrayList<>();
		
	@JsonProperty("company_staff_interview")
	private List<CompanyStaffInterviewDto> listOfCompanyStaffInterview = new ArrayList<>();
	
	@JsonProperty("company_career_advice")
	private List<CompanyCareerAdviceElasticDto> listOfCompanyCareerAdvice = new ArrayList<>();
	
	@JsonProperty("company_working_hours")
	private List<CompanyWorkingHoursDto> listOfCompanyWorkingHours = new ArrayList<>();

	@JsonProperty("contact_details")
	private List<CompanyContactDetailDto> contactDetails = new ArrayList<>();
	
	@Override
	public String getIdentifier() {
		return this.getId();
	}
	
}