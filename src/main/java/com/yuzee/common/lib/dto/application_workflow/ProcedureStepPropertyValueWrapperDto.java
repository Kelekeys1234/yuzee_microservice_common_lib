package com.yuzee.common.lib.dto.application_workflow;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class ProcedureStepPropertyValueWrapperDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("pre_training_schedule")
	private List<ProcedureStepPropertyPreTraningScheduleDto> preTrainingSchedules;
	
	@JsonProperty("pre_traning_review_attachment")
	private List<AttachmentDto> preTrainingReviewAttachment;
	
	@JsonProperty("property_value")
	private String propertyValue;
	
	@JsonProperty("pre_traning_review_location")
	private LocationDto preTrainingReviewlocation;
	
	@JsonProperty("payment_option")
	private List<ProcedureStepPropertyPayment> paymentOptions;
	
	
}
