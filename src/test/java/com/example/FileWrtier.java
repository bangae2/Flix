package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * Created by bangae1 on 2016-07-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@Transactional
public class FileWrtier {

    public static void main(String[] args) {
        String img = "/attach/images/cover/";


        String path = img.substring(0, img.lastIndexOf("/"));
        System.out.println(path);
        path = path.substring(0, path.lastIndexOf("/"));
        System.out.println(path);

    }

}
