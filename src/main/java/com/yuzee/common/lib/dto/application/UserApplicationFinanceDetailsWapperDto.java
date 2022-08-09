package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApplicationFinanceDetailsWapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("finance_details_id")
	private UUID _id;
	
	@NotNull(message = "{user_application.finance_details.who_is_paying_for_type.is_required}")
	@JsonProperty("who_is_paying_for_type")
	private String whoIsPayingForType;
	
	@NotNull(message = "{user_application.finance_details.budget_currency.is_required}")
	@JsonProperty("budget_currency")
	private String budgetCurrency;
	
	@JsonProperty("budget_min_amount")
	private Double budgetMinAmount;
	
	@JsonProperty("budget_max_amount")
	private Double budgetMaxAmount;
	
	@Valid
	@JsonProperty("family_member")
	private Set<UserApplicationFinanceFamilyMemberIdsListDto> familyMembers;

}
