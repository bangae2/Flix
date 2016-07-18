package com.example.controller;

import com.example.entity.VideosEntity;
import com.example.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by bangae1 on 2016-07-05.
 */
@Controller
public class MainController {
    @Autowired
    private VideosService videosService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String index(Model model) {
        return "pages/login";
    }

//    @RequestMapping(value="/error", method = RequestMethod.GET)
//    public String error(Model model) {
//        return "/error";
//    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String main(Model model) {
        List<VideosEntity> lists = this.videosService.findPaging(1);
        debug(lists);
        model.addAttribute("videos", lists);
        return "pages/main";
    }

    @RequestMapping(value="/search/{text}", method = RequestMethod.POST)
    public String search(@PathVariable("text")String text, Model model) {
        List<VideosEntity> lists = this.videosService.findSearch(text);
        debug(lists);
        model.addAttribute("videos", lists);
        return "pages/main";
    }

    @RequestMapping(value="/menu/{genre}", method = RequestMethod.GET)
    public String menu(@PathVariable("genre")String genre, Model model) {
        List<VideosEntity> lists = this.videosService.findGenre(genre);
        debug(lists);
        model.addAttribute("videos", lists);
        return "pages/main";
    }

    public void debug(List<VideosEntity> lists) {
        for(VideosEntity ve : lists) {
            String file_path = ve.getFile_path();
            ve.setFile_path("c:" + file_path);

        }
    }
}
