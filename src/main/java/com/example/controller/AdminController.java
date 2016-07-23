package com.example.controller;

import com.example.config.HibernateProxyTypeAdapter;
import com.example.entity.VideosEntity;
import com.example.entity.VideosKindEntity;
import com.example.service.VideosKindService;
import com.example.service.VideosService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.util.List;

/**
 * Created by bangae1 on 2016-07-21.
 */
@Controller
@RequestMapping("/admin")
@PropertySource(value = "classpath:config.properties")
public class AdminController {
    @Autowired
    private Environment env;

    @Autowired
    private VideosKindService videosKindService;

    @Autowired
    private VideosService videosService;

    @RequestMapping(value = "/kind", method = RequestMethod.GET)
    public String kind(Model model) {
        List<VideosKindEntity> kinds = videosKindService.findByFlag();
        model.addAttribute("kinds", kinds);
        model.addAttribute("movies", videosService.findAllByVideoKindSeq(kinds.get(0).getVideo_kind_seq()));
        return "admin/kind";
    }

    @RequestMapping(value = "/findMovie/{video_kind_seq}", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findKind(Model model, @PathVariable("video_kind_seq")int video_kind_seq) {
        List<VideosEntity> lists = this.videosService.findAllByVideoKindSeq(video_kind_seq);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        return gson.toJson(lists);
    }

    @RequestMapping(value = "/kindUP", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String kindUP(@RequestParam("thumbnail")MultipartFile file, @ModelAttribute("cmd")VideosKindEntity videosKindEntity) {
//        MultipartFile file = multipartRequest.getFile("thumbnail");
        return this.videosKindService.kindUp(videosKindEntity, file);
    }

    @RequestMapping(value = "/kindDel/{video_kind_seq}", method = RequestMethod.POST, produces = "plain/text;charset=utf-8")
    @ResponseBody
    public String kindDel(@PathVariable("video_kind_seq")int video_kind_seq) {
        this.videosKindService.delete(video_kind_seq);
        return "";
    }

    @RequestMapping(value = "/movieUP", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String movieUP(@RequestParam("movie")MultipartFile multipartFile, @ModelAttribute("cmd")VideosEntity videosEntity) {
        String file_name = multipartFile.getOriginalFilename();
        videosEntity.setFile_name(file_name);
//        /attach/BreakingBad1/
        VideosKindEntity videosKindEntity = videosKindService.findOne(videosEntity.getVideo_kind_seq());
        String cover_path = videosKindEntity.getCover_path();
        cover_path = cover_path.substring(0, cover_path.lastIndexOf("/"));
        cover_path = cover_path.substring(0, cover_path.lastIndexOf("/")+1);
        videosEntity.setFile_path(cover_path + env.getProperty("video.real.resource.path"));
        videosEntity.setThumbnail(file_name.substring(0, file_name.lastIndexOf(".")+1)+"jpg");
        System.out.println(videosEntity.toString());
        return "";
    }
}
