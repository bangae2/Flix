package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bangae1 on 2016-07-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@Transactional
public class FileWrtier {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:SS");
        System.out.println(sdf.format(new Date()));
    }

}
