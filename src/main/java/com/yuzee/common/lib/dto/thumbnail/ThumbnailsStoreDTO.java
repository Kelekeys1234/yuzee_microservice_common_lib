package com.yuzee.common.lib.dto.thumbnail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThumbnailsStoreDTO implements Serializable {

    private static final long serialVersionUID = -989283794872398222L;

    private String storageId;

    List<ThumbnailDTO> thumbnails = new ArrayList<>();

}
