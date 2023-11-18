package com.yunyun.application.controller;


import com.yunyun.application.config.WXConfig;
import com.yunyun.application.task.AsyncTask;
import com.yunyun.application.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/test")
@PropertySource("classpath:pay.properties")
public class TestController {

    @Value("${wxpay.appid}")
    private  String payAppid;

    @Value("${wxpay.sercret}")
    private String paySecred;

    @GetMapping("get_config")
    public JsonData testConfig(){

        Map<String, String> map = new HashMap<>();
        map.put("appid", payAppid);
        map.put("sercret", paySecred);

        return  JsonData.buildSuccess(map);


    }


    @Autowired
    private WXConfig wxConfig;


    @GetMapping("list")
    public JsonData testExt(){
         int i =1/0;
        return JsonData.buildSuccess("");

    }

    @GetMapping("get_config01")
    public JsonData testConfig01(){

        Map<String, String> map = new HashMap<>();

        map.put("appid", wxConfig.getPayAppid());
        map.put("sercret", wxConfig.getPayMechId());
        map.put("mechid", wxConfig.getPaySecret());

        return JsonData.buildSuccess(map);
    }


    @Autowired
    private AsyncTask asyncTask;



    @GetMapping("async")
    public JsonData testAsync(){

        long begin = System.currentTimeMillis();
       /* asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();*/

       Future<String> task4 = asyncTask.task4();
       Future<String> task5 = asyncTask.task5();

       for(;;){
           if(task4.isDone() && task5.isDone()){
               try {
                   String task4Result = task4.get();
                   System.out.println(task4Result);

                   String task5Result = task5.get();
                   System.out.println(task5Result);


               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (ExecutionException e) {
                   e.printStackTrace();
               }finally {
                   break;
               }
           }
       }

        long end = System.currentTimeMillis();

        return JsonData.buildSuccess(end - begin);

    }



}


