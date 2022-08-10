package com.yuzee.common.lib.dto.notification;

import java.io.Serializable;
import java.util.HashMap;

import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentTemplateDataDto implements Serializable {
	
	private static final long serialVersionUID = -7499404356358173135L;

	@JsonProperty("entityId")
	private String entityId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("target")
	private String target;
	
	private HashMap<Object, Object> queryData=new HashMap<>();
	
	public ContentTemplateDataDto(String entityId, String name, String target) {
		this.entityId = entityId;
		this.name = name;
		this.target = target;
	}
}
