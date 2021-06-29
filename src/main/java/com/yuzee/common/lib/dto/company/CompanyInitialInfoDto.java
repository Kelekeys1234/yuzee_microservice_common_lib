package com.yuzee.common.lib.dto.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInitialInfoDto {

	@JsonProperty("company_id")
	private String companyId;
	
	@JsonProperty("company_name")
	private String companyName;
	
	@JsonProperty("year_founded")
	private Integer yearFounded;
	
	@JsonProperty("cities")
	private Set<String>  city;
	
	@JsonProperty("countries")
	private Set<String> country;
	
	@JsonProperty("status")
	private Boolean status;
	
	@JsonProperty("last_updated")
	private String lastUpdated;
	
	@JsonProperty("total_jobs")
	private Long totalJobs;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("logo_url")
	private String logoUrl;
	
	@JsonProperty("rating")
	private Double rating;
	
	@JsonProperty("is_owner")
	private boolean isOwner;
	
	@JsonProperty("number_of_jobs")
	private long jobsCount;
	
	@JsonProperty("storages")
	private List<StorageDto> storages = new ArrayList<>();

	public CompanyInitialInfoDto(String companyId, String companyName, Integer yearFounded, Set<String> city,
			Set<String> country, Boolean status, String lastUpdated) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.yearFounded = yearFounded;
		this.city = city;
		this.country = country;
		this.status = status;
		this.lastUpdated = lastUpdated;
	}

	public CompanyInitialInfoDto(String companyId, String companyName, Integer yearFounded, Set<String> city,
			Set<String> country, Boolean status, String lastUpdated, String address, String description,
			boolean isOwner) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.yearFounded = yearFounded;
		this.city = city;
		this.country = country;
		this.status = status;
		this.lastUpdated = lastUpdated;
		this.address = address;
		this.description = description;
		this.isOwner = isOwner;
	}

	public CompanyInitialInfoDto(String companyId, String companyName, Integer yearFounded, Boolean status,
			 String description) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.yearFounded = yearFounded;
		this.status = status;
		this.description = description;
	}
}