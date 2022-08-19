package com.yuzee.common.lib.dto.thumbnail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThumbnailDTO implements Serializable {

    private static final long serialVersionUID = -989283794872398222L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("width")
    private int width;

    @JsonProperty("height")
    private int height;

    @JsonProperty("storedThumbnailName")
    private String storedThumbnailName;

}
