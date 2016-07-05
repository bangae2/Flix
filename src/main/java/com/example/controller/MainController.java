package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bangae1 on 2016-07-05.
 */
@Controller
public class MainController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String main(Model model) {
        return "pages/content";
    }
}
