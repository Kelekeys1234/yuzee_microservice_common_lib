package com.yuzee.common.lib.dto;

import java.util.List;

import lombok.Data;

@Data
public class GenericRequestWrapper<T> {
	private List<T> data;
}
