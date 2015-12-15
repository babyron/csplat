package com.platform.croudsource.controller;

import com.platform.croudsource.dao.MissionDao;
import com.platform.croudsource.dao.UserDao;
import com.platform.croudsource.entity.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        List<Mission> missionList = missionDao.getMissions();
        request.setAttribute("count", count);

        double budget = 0;
        double remainBudget = 0;

        for(Mission mission: missionList){
            budget += mission.getBudget();
            remainBudget += mission.getRemainbudget();
        }

        request.setAttribute("budget", budget - remainBudget);
        request.setAttribute("remainBudget", remainBudget);
        return "dashboard";
    }
}
