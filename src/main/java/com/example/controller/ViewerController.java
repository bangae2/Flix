package com.example.controller;

import com.example.entity.VideosEntity;
import com.example.service.VideosService;
import com.example.util.VideoRemoveUtil;
import com.google.common.io.ByteStreams;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * Created by bangae1 on 2016-07-16.
 */
@Controller
@RequestMapping("/viewer")
@PropertySource("classpath:config.properties")
public class ViewerController {
    @Autowired
    private Environment env;
    @Autowired
    private VideosService videosService;

    @RequestMapping(value = "/image/{video_seq}", method = RequestMethod.GET)
    public HttpEntity<byte[]> imageView(@PathVariable("video_seq")Integer video_seq, HttpServletRequest req, HttpServletResponse res) {
        VideosEntity videosEntity = this.videosService.findOne(video_seq);
        System.out.println("c:"+videosEntity.getFile_path() + "thumbnail/" + videosEntity.getThumbnail());
        File file = new File("c:"+videosEntity.getFile_path() + "thumbnail/" + videosEntity.getThumbnail());
        byte[] imageBytes = null;
        String mimeType = "";
        FileInputStream fis = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            fis = new FileInputStream(file);
            mimeType = new MimetypesFileTypeMap().getContentType(file);
            imageBytes = IOUtils.toByteArray(fis);
            headers.setContentType(MediaType.valueOf(mimeType));
            headers.setContentLength(file.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new HttpEntity<byte[]>(imageBytes, headers);
    }

    @ResponseBody
    @RequestMapping(value = "/video/{video_seq}", method = RequestMethod.POST, produces = "plain/text;charset=utf-8")
    public String video(@PathVariable("video_seq")Integer video_seq, HttpServletResponse res, HttpServletRequest req) {
        VideosEntity videosEntity = this.videosService.findOne(video_seq);
        debug(videosEntity);
        String temp = env.getProperty("video.temp.path");
        String realPath = videosEntity.getFile_path()+videosEntity.getFile_name();
        File file = new File(realPath);
        FileInputStream fis =null;
        FileOutputStream fos = null;
        FileChannel fin = null;
        FileChannel fout = null;
        String uuid = UUID.randomUUID().toString();
        String fileName = file.getName();
        fileName = fileName.substring(fileName.length() -4);
        try {

            fis = new FileInputStream(file);
            fos = new FileOutputStream(temp + uuid + fileName);

            fin = fis.getChannel();
            fout = fos.getChannel();

            ByteBuffer buf = ByteBuffer.allocateDirect((int) file.length());

            fin.read(buf);
            buf.flip();
            fout.write(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(fos);
            close(fis);
            close(fout);
            close(fin);
            VideoRemoveUtil util = new VideoRemoveUtil(temp + uuid + fileName);
        }
        return env.getProperty("video.resource.path") + uuid + fileName;

    }

    public void debug(VideosEntity ve) {
            String file_path = ve.getFile_path();
            ve.setFile_path("c:" + file_path);
    }

    public static void close(Closeable c) {
        if (c == null) return;
        try {
            c.close();
        } catch (IOException e) {
            //log the exception
        }
    }
}
