package com.platform.croudsource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ron on 2015/12/9.
 */
@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {
    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        return "dashboard";
    }
}
