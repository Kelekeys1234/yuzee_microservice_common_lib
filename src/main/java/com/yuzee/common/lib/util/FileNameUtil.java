package com.yuzee.common.lib.util;

import com.yuzee.common.lib.dto.FileNameDTO;

public class FileNameUtil {
	private FileNameUtil() {
	}
	public static FileNameDTO getFileNameFromKey(String fileKey) {
		if(fileKey.lastIndexOf(".")<0) {
			return new FileNameDTO(fileKey, "");
		}
		String fileNamePrefix = fileKey.substring(0, fileKey.lastIndexOf("."));
		String extention = fileKey.substring(fileKey.lastIndexOf(".")+1, fileKey.length());
		return new FileNameDTO(fileNamePrefix, extention);
	}
}
