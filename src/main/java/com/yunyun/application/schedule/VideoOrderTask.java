package com.yunyun.application.schedule;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class VideoOrderTask {


    //@Scheduled(fixedRate = 2000)
   // @Scheduled(cron= "*/1 * * * * *")
    public void sun(){
        System.out.println(LocalDateTime.now() + "当前交易额" + Math.random());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
