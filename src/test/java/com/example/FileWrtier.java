package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;

/**
 * Created by bangae1 on 2016-07-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@Transactional
public class FileWrtier {

    public static void main(String[] args) {
        String path = "/home/bangae1/IdeaProjects/Flix/build/resources/main/static/videos/";
        String oriFile ="/home/bangae1/Downloads/SampleVideo_1280x720_10mb.mp4";
        File file = new File(oriFile);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(oriFile);
            fos = new FileOutputStream(new File(path + "123.mp4"));
            byte[] b = new byte[1024];
            int s = 0;
            while((s = fis.read(b)) != 0) {
                fos.write(b,0,s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null) try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(fos != null) try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
