package com.platform.croudsource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ron on 2015/12/9.
 */

@Controller
@RequestMapping(value = "/mission")
public class MissionController {

    @RequestMapping(value = "/task1")
    public String task1(){
        return "task1";
    }

    @RequestMapping(value = "/task2")
    public String task2(){
        return "task2";
    }

    @RequestMapping(value = "/task3")
    public String task3(){
        return "task1";
    }

    @RequestMapping(value = "/task4")
    public String task4(){
        return "task4";
    }
}
