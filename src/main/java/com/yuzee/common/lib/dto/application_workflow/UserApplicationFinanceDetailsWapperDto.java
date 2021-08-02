package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class UserApplicationFinanceDetailsWapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "finance_details_id", access = Access.READ_ONLY)
	private String id;
	
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
	@NotNull(message = "{user_application.family_member.is_required}") 
	@JsonProperty("family_member")
	private List<UserApplicationFamilyMemberIdsListDto> familyMembers;

}
