package com.yuzee.common.lib.dto;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuzee.common.lib.enumeration.EventType;
import com.yuzee.common.lib.util.ObjectMapperHelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SystemEventDTO {
	
    @JsonProperty("version")
    private final String version = "0.0.1";

    @JsonProperty("event_time")
    protected long eventTime;
    
    @JsonProperty("event_type")
    private EventType messageType;

    @JsonProperty("payload")
    private Object payload;
    
    @SuppressWarnings("unchecked")
    public <T> T getPayloadByClass(Class<T> valueType) {
        String value = ObjectMapperHelper.toCompactJSON(payload);
        try {
            return ObjectMapperHelper.readValueFromJSON(value, valueType);
        } catch (IOException ex) {
            log.error("getPayloadByClass Parsing Failed",ex);
        }
        return (T) payload;
    }
    
    public String toJSONString() {
        return ObjectMapperHelper.toCompactJSON(this);
    }
    
}
