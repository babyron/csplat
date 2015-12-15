package com.platform.croudsource.controller;

import com.platform.croudsource.dao.MissionDao;
import com.platform.croudsource.dao.UserDao;
import com.platform.croudsource.entity.MinPay;
import com.platform.croudsource.entity.Mission;
import com.platform.croudsource.entity.UCBQA;
import com.platform.croudsource.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ron on 2015/12/9.
 */

@Controller
@RequestMapping(value = "/mission")
public class MissionController {

    @Autowired
    private MissionDao missionDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/task1")
    public String task1(HttpServletRequest request, HttpServletResponse response){
        return "task1";
    }

    @RequestMapping(value = "/task1/submit")
    public String task1Submit(HttpServletRequest request){
        int missionType = Integer.parseInt(request.getParameter("mission_type").trim());
        request.setAttribute("mission_type", missionType);
        if(missionType == 1){
            return "task2";
        }else{
            return "task3";
        }
    }

    private int getMissionAttrInt(String s){
        return StringUtils.isEmpty(s)? 0: Integer.parseInt(s);
    }

    private double getMissionAttrDouble(String s){
        return StringUtils.isEmpty(s)? 0 : Double.parseDouble(s);
    }

    @RequestMapping(value = "/task2/submit")
    public String task2Submit(HttpServletRequest request){
        Mission mission = new Mission();
        mission.setName(request.getParameter("name"));

        String pay = request.getParameter("pay");
        String times = request.getParameter("times");
        String time = request.getParameter("time");
        String value = request.getParameter("value");
        String type = request.getParameter("type");
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String a1 = request.getParameter("a1");
        String a2 = request.getParameter("a2");
        String a3 = request.getParameter("a3");
        String a4 = request.getParameter("a4");
        String a5 = request.getParameter("a5");
        String a6 = request.getParameter("a6");
        String a7 = request.getParameter("a7");
        String a8 = request.getParameter("a8");


        mission.setPay(getMissionAttrDouble(pay));
        mission.setTimes(getMissionAttrInt(times));
        mission.setTime(getMissionAttrInt(time));
        mission.setType(getMissionAttrInt(type));
        mission.setValue(getMissionAttrInt(value));
        mission.setX(getMissionAttrDouble(x));
        mission.setY(getMissionAttrDouble(y));
        mission.setA1(getMissionAttrDouble(a1));
        mission.setA2(getMissionAttrDouble(a2));
        mission.setA3(getMissionAttrDouble(a3));
        mission.setA4(getMissionAttrDouble(a4));
        mission.setA5(getMissionAttrDouble(a5));
        mission.setA6(getMissionAttrDouble(a6));
        mission.setA7(getMissionAttrDouble(a7));
        mission.setA8(getMissionAttrDouble(a8));

        missionDao.insertMission(mission);
        return "task4";
    }


    @RequestMapping(value = "/task3/submit")
    public String task3Submit(HttpServletRequest request){
        Mission mission = new Mission();
        mission.setName(request.getParameter("name"));

        String times = request.getParameter("times");
        String value = request.getParameter("value");
        String type = request.getParameter("type");
        String x = request.getParameter("x");
        String y = request.getParameter("y");


        mission.setTimes(getMissionAttrInt(times));
        mission.setType(getMissionAttrInt(type));
        mission.setValue(getMissionAttrInt(value));
        mission.setX(getMissionAttrDouble(x));
        mission.setY(getMissionAttrDouble(y));

        missionDao.insertMission(mission);
        return "task4";
    }

    @RequestMapping(value = "/currentboard")
    public String currentMission(HttpServletRequest request){
        List<Mission> missionList = missionDao.getMissionByType(1);

        request.setAttribute("missionList", missionList);

        return "currentboard";
    }

    @RequestMapping(value = "/detail")
    public String detail(HttpServletRequest request){
        ArrayList<User> userList = userDao.getUsers();
        Mission mission = missionDao.getMission(Integer.parseInt(request.getParameter("id")));
        UCBQA ucbqa = new UCBQA();
        ArrayList<Mission> missionList = new ArrayList<Mission>();
        missionList.add(mission);
        List<User> result = ucbqa.Calculation(userList, missionList, 0.05, 8, 1000);

        missionDao.updateBudget(missionList);
        request.setAttribute("result", result);
        request.setAttribute("mission", missionList.get(0));
        request.setAttribute("type", 1);
        userDao.updateAB(result);
        return "detail";
    }

    @RequestMapping(value = "/type2")
    public String type2(HttpServletRequest request){
        MinPay minPay = new MinPay();
        ArrayList<User> users = userDao.getUsers();
        ArrayList<Mission> missions = missionDao.getMissionByType(2);

        List<User> result = minPay.getUserList(users, missions);

        request.setAttribute("result", result);
        request.setAttribute("missions", missions);
        request.setAttribute("type", 2);
        return "detail";
    }


    @RequestMapping(value = "/delete")
    public String delete(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        missionDao.deleteMission(id);

        List<Mission> missionList = missionDao.getMissions();

        request.setAttribute("missionList", missionList);
        return "currentboard";
    }

    @RequestMapping(value = "/task2")
    public String task2(){
        return "task2";
    }

    @RequestMapping(value = "/task3")
    public String task3(){
        return "task3";
    }

    @RequestMapping(value = "/task4")
    public String task4(){
        return "task4";
    }


}
