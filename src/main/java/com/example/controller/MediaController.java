package com.example.controller;

import com.example.entity.UsersEntity;
import com.example.entity.VideoLogEntity;
import com.example.entity.VideosEntity;
import com.example.service.VideoLogService;
import com.example.service.VideosKindService;
import com.example.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private VideoLogService videoLogService;

    @RequestMapping(value = "/list/{video_seq}", method = RequestMethod.GET)
    public String mediaList(@PathVariable("video_seq")Integer video_seq, Model model) {
        VideosEntity videosEntity = this.videosService.findOne(video_seq);
        model.addAttribute("video",videosEntity);
        model.addAttribute("videos", this.videosService.findAllByVideoKindSeq(videosEntity.getVideo_kind_seq()));
        model.addAttribute("videoKind",this.videosKindService.findOne(videosEntity.getVideo_kind_seq()));
        return "pages/media";
    }

    @RequestMapping(value = "/log/save/{video_seq}", method = RequestMethod.POST)
    @ResponseBody
    public String mediaLog(@PathVariable("video_seq")Integer video_seq) {
        UsersEntity usersEntity = (UsersEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        VideoLogEntity videoLogEntity = new VideoLogEntity();
        videoLogEntity.setVideo_seq(video_seq);
        videoLogEntity.setId(usersEntity.getId());
        System.out.println(videoLogEntity.getVideo_seq() + "***");
        videoLogService.save(videoLogEntity);
        return "success";
    }
}
