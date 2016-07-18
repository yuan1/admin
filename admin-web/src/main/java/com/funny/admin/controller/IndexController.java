package com.funny.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.sound.midi.Soundbank;

/**
 * Created by fangli@autohome.com.cn on 2016/6/17.
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @RequestMapping("/main")
    public ModelAndView main() {
        return new ModelAndView("main");
    }
}
