package net.xdclass.demoproject;


import com.yunyun.application.Application;
import com.yunyun.application.controller.UserController;
import com.yunyun.application.domain.User;
import com.yunyun.application.domain.Video;
import com.yunyun.application.service.VideoService;
import com.yunyun.application.util.JsonData;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
public class UserTest {


    @Autowired
    private UserController userController;



    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testVideoListApi() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);

        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);

    }



    @Test
    public void loginTest(){

        User user = new User();
        user.setUsername("tiantian");
        user.setPwd("123");

        JsonData jsonData = userController.login(user);

        System.out.println(jsonData.toString());

        TestCase.assertEquals(0, jsonData.getCode());


    }







}
