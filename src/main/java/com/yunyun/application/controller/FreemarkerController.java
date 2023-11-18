package com.yunyun.application.controller;


import com.yunyun.application.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freemaker")
public class FreemarkerController {


    @Autowired
    private WXConfig wxConfig;

    @GetMapping("test")
    public String index(ModelMap modeMap){

        modeMap.addAttribute("setting", wxConfig);


        return "user/fm/index";


    }


}
