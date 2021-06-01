package com.yuzee.common.lib.dto.elastic;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElasticSearchBulkWrapperDto {
	private List<ElasticSearchDTO> entities;
}
