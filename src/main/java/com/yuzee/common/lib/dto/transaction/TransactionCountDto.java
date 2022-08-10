package com.yuzee.common.lib.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionCountDto {

	@JsonProperty("transaction_count")
	private int transactionCount;
	
}
