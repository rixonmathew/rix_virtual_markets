package com.rixon.virtualmarket.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("${rvm.ui.endpoint}")
public class UIController {


    @RequestMapping
    public ModelAndView home() {
        return new ModelAndView("rvmui/ui");
    }

    @RequestMapping("${rvm.brokers.endpoint}")
    public ModelAndView brokers() {
        return new ModelAndView("rvmui/brokers");
    }


}
