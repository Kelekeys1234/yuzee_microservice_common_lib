package com.yuzee.common.lib.dto.common;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@CompoundIndexes({
    @CompoundIndex(name = "UK_N", def = "{'name' : 1}", unique = true)
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class VaccinationDto implements Serializable {

	private static final long serialVersionUID = 7212322131662599199L;

	@JsonProperty("id")
	private UUID _id;

	@JsonProperty("name")
	private String name;
}
