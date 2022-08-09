package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.dto.storage.StorageDto;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class ProcedureStepPropertyValueWrapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("pre_training_schedule")
	private List<ProcedureStepPropertyPreTraningScheduleDto> preTrainingSchedules;
	
	@JsonProperty("attachments")
	private List<StorageDto> attachmenss;
	
	@JsonProperty("property_value")
	private String propertyValue;
	
	@JsonProperty("location")
	private LocationDto location;
	
	@JsonProperty("payment_option")
	private List<ProcedureStepPropertyPayment> paymentOptions;
	
	
}
