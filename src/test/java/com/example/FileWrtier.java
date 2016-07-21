package com.example;

import org.apache.commons.io.FileUtils;
import org.omg.SendingContext.RunTime;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by bangae1 on 2016-07-16.
 */
public class FileWrtier {
    public static void main(String[] args) {


        String uuid = UUID.randomUUID().toString();
        String file = "C:\\attach\\BreakingBad1\\Breaking.Bad.S01E01.720p.HDTV.x264.mp4";
        String tempFile = "C:\\attach\\BreakingBad1\\" + UUID.randomUUID().toString() + ".mp4";
        File sfile = new File(file);
        File efile = new File(tempFile);
        try {
            FileUtils.copyFile(sfile, efile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
