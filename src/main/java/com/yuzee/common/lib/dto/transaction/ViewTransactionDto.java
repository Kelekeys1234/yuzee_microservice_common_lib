package com.yuzee.common.lib.dto.transaction;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.user.UserInitialInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ViewTransactionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("trasanction_id")
	private UUID _id;
	
	@JsonProperty("entity_id")
	@NotBlank(message = "entity_id should not be blank")
	private String entityId;
	
	@JsonProperty("entity_type")
	@NotBlank(message = "entity_type should not be blank")
	private String entityType;
	
	@JsonProperty("transaction_type")
	@NotBlank(message = "transaction_type should not be blank")
	private String transactionType;
	
	@JsonProperty("user")
	private UserInitialInfoDto user;
}
