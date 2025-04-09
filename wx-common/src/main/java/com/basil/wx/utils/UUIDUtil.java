package com.basil.wx.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(MultipartFile file) {
        if (file == null) {
            return null;
        }
        //f7a9f3e6805a4e81b5d27245c6c30070
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // a.png
        String filename = file.getOriginalFilename();
        // .png
        String extension = filename.substring(filename.lastIndexOf("."));
        // f7a9f3e6805a4e81b5d27245c6c30070.png
        String newFilename = uuid + extension;
        return newFilename;
    }
}
