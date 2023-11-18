package com.yunyun.application.controller;


import com.yunyun.application.util.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @GetMapping("save")
    public JsonData saveOrder(){



        return  JsonData.buildSuccess("下单成功");
    }



}
