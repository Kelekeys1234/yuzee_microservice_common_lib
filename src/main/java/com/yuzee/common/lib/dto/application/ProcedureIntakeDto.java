package com.yuzee.common.lib.dto.application;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureIntakeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("intake_id")
	private String id;
	
	@NotNull(message = "{procedure.intake.intake_date.is_required}") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("intake_date")
	private Date intakeDate;
}
