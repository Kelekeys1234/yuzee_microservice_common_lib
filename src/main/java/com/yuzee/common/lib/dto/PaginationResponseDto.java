package com.yuzee.common.lib.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponseDto<T> {

	@JsonProperty("response")
	private T response;
	
	@JsonProperty("total_count")
	private Long totalCount;
	
	@JsonProperty("page_number")
	private Long pageNumber;
	
	@JsonProperty("has_previous_page")
	private Boolean hasPreviousPage;
	
	@JsonProperty("has_next_page")
	private Boolean hasNextPage;
	
	@JsonProperty("total_pages")
	private Long totalPages;}
