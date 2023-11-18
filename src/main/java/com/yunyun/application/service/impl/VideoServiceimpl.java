package com.yunyun.application.service.impl;

import com.yunyun.application.controller.mapper.VideoMapper;
import com.yunyun.application.domain.Video;
import com.yunyun.application.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
public class VideoServiceimpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;


    public List<Video> listVideo(){

        return videoMapper.listVideo();

    }
}
