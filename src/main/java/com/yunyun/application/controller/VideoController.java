package com.yunyun.application.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunyun.application.domain.Video;
import com.yunyun.application.service.VideoService;
import com.yunyun.application.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yunyun.application.util.JsonData.buildSuccess;


@RestController
@RequestMapping("/api/v1//video")
public class VideoController {


    @Autowired
    private VideoService videoService;


    //@RequestMapping(value = "list", method = RequestMethod.GET)
    @GetMapping("list")
    public Object list() throws JsonProcessingException {

        List<Video> list = videoService.listVideo();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonstr = objectMapper.writeValueAsString(list);
        System.out.println(jsonstr);

        List<Video> temp= objectMapper.readValue(jsonstr, List.class);
        System.out.println(temp);

        return buildSuccess(list);
    }


    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){

        System.out.println(video.toString());

        return JsonData.buildSuccess(video);
    }


}
