package com.example.controller;

import com.example.entity.VideosEntity;
import com.example.service.VideosKindService;
import com.example.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bangae1 on 2016-07-16.
 */
@Controller
@RequestMapping("/media")
public class MediaController {
    @Autowired
    private VideosService videosService;

    @Autowired
    private VideosKindService videosKindService;

    @RequestMapping(value = "/list/{video_seq}", method = RequestMethod.GET)
    public String mediaList(@PathVariable("video_seq")Integer video_seq, Model model) {
        VideosEntity videosEntity = this.videosService.findOne(video_seq);
        model.addAttribute("video",videosEntity);
        model.addAttribute("videos", this.videosService.findAllByVideoKindSeq(videosEntity.getVideo_kind_seq()));
        model.addAttribute("videoKind",this.videosKindService.findOne(videosEntity.getVideo_kind_seq()));
        return "pages/media";
    }
}
