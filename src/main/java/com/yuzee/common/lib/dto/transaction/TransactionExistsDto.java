package com.yuzee.common.lib.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionExistsDto {
	@JsonProperty("transaction_exists")
	private boolean transactionExists;
}
