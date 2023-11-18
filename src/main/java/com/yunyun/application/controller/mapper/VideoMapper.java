package com.yunyun.application.controller.mapper;

import com.yunyun.application.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();


    static {

        videoMap.put(1, new Video(1,"初始数据标题1111"));
        videoMap.put(2, new Video(2,"初始数据标题2222"));
        videoMap.put(3, new Video(3,"初始数据标题3333"));
        videoMap.put(4, new Video(4,"初始数据标题4444"));
        videoMap.put(5, new Video(5,"初始数据标题55555"));

    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();

        list.addAll(videoMap.values());

        return  list;


    }


}
