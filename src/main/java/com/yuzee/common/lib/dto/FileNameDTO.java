package com.yuzee.common.lib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileNameDTO {
	String fileNamePrefix;
	String extension;
}