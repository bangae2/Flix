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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

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

    @RequestMapping(value = "/kindUP", method = RequestMethod.POST, produces = "plain/text;charset=utf-8")
    @ResponseBody
    public String kindUP(MultipartRequest multipartRequest, @ModelAttribute("cmd")VideosKindEntity videosKindEntity) {
        MultipartFile file = multipartRequest.getFile("thumbanail");
        String realPath = env.getProperty("video.real.path") + file.getOriginalFilename() + "/";
        videosKindEntity.setCover_path(realPath);


        return "";
    }

}
