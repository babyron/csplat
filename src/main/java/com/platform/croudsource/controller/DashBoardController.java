package com.platform.croudsource.controller;

import com.platform.croudsource.dao.MissionDao;
import com.platform.croudsource.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ron on 2015/12/9.
 */
@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MissionDao missionDao;

    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(HttpServletRequest request) {
        int count = missionDao.getMissionCount();

        request.setAttribute("count", count);
        return "dashboard";
    }
}
