package com.yuzee.common.lib.dto.thumbnail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThumbnailStoreDTO implements Serializable {

    private static final long serialVersionUID = -989283794872398222L;

    private String id;

    private String storageId;

    private int width;

    private int height;

    private String storedThumbnailName;

}
