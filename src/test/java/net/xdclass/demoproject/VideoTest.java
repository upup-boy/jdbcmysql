package net.xdclass.demoproject;


import com.yunyun.application.Application;
import com.yunyun.application.domain.Video;
import com.yunyun.application.service.VideoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class VideoTest {


    @Autowired
    private VideoService videoService;

    @Before
    public void testOne(){
        System.out.println("测试before");
    }

    @Test
    public void testTwo(){
        System.out.println("测试test");

        TestCase.assertEquals(1,3);
    }



    @Test
    public void testVideoList(){

        List<Video> videoList = videoService.listVideo();

        TestCase.assertTrue(videoList.size()>0);
    }

    @After
    public void testThree(){
        System.out.println("测试after");
    }





}
