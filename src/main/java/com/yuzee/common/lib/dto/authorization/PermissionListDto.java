package com.yuzee.common.lib.dto.authorization;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("permissions")
	private List<PermissionDto> permissions;
}
