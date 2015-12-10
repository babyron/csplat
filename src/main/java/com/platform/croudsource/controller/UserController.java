package com.platform.croudsource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ron on 2015/12/9.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/profile")
    public String user(){
        return "profile";
    }
}
