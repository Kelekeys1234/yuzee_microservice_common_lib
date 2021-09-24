package com.yuzee.common.lib.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ElasticType {

	ALL, COURSE("course"), FACULTY("faculty"), INSTITUTE("institute"), LEVEL("level"), SCHOLARSHIP("scholarship"),
	USER("user"), APPLICATION("application"), NETWORK("network"), COMPANY("company");

	@Getter
	String className;

}
