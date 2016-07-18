package com.example;

import java.util.UUID;

/**
 * Created by bangae1 on 2016-07-16.
 */
public class FileWrtier {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        String file = "Demolition 2015 1080p WEB-DL x264 AC3-JYK.mp4";
        file = file.substring(file.length() -4);
        System.out.println(uuid + file);

    }
}
