package com.yuzee.common.lib.dto.elastic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsersResponseDto {

	@JsonProperty("user_list")
	private List<UserElasticSearchDto> userList;
	
	@JsonProperty("total_count")
	private Long totalCount;
	
	@JsonProperty("page_number")
	private Long pageNumber;
	
	@JsonProperty("has_previous_page")
	private Boolean hasPreviousPage;
	
	@JsonProperty("has_next_page")
	private Boolean hasNextPage;
	
	@JsonProperty("total_pages")
	private Long totalPages;
	

}
