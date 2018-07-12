package com.lwc.dto;

import lombok.Data;

/**
 * @author eddie.lee
 * @Package com.lwc.dto
 * @ClassName FileInfo
 * @description
 * @date created in 2018-07-13 0:29
 * @modified by
 */
@Data
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

}
