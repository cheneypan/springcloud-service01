package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cheney on 2018/8/2.
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    @GetMapping("")
    public String hello(String name) {
        logger.info("name = {}", name);
        if (null == name || name.trim().equals("")) {
            return String.format("[%s]the name is null", df.format(new Date()));
        }
        return String.format("[%s][test]hello, %s!", df.format(new Date()), name);
    }

    @GetMapping("/reply")
    public String reply(String message){
        String reply = String.format("[%s]reply01, %s!", df.format(new Date()), message);
        logger.info(reply);
        return reply;
    }
}
