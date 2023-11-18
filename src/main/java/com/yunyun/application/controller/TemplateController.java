package com.yunyun.application.controller;


import com.yunyun.application.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tpl")
public class TemplateController {

    @Autowired
    private WXConfig wxConfig;

    @GetMapping("thymeleaf")
    public String index(ModelMap modelMap){

        modelMap.addAttribute("setting", wxConfig);

        return "tl/index";

    }
}
