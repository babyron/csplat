package com.platform.croudsource.dao;

import com.platform.croudsource.entity.Mission;
import com.platform.croudsource.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ron on 2015/12/9.
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(){

    }

    private ArrayList<Integer> getS(String s){
        String ss[] = s.trim().split(" ");
        ArrayList<Integer> sList = new ArrayList<Integer>();
        sList.add(Integer.parseInt(ss[0]));
        return sList;
    }

    private double[] getP(String s){
        String ss[] = s.trim().split(" ");
        double p[] = new double[8];
        for(int i = 0; i < 8; i++){
            p[i] = Double.parseDouble(ss[i]);
        }
        return p;
    }

    public ArrayList<User> getUsers(){
        String sql = "select * from t_user";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        ArrayList<User> userList = new ArrayList<User>();

        for(Map<String, Object> map:list){
            User u = new User();
            u.setId((Integer) map.get("Uid"));
            u.setName((String) map.get("Uname"));
            u.setX((Double) map.get("Ux"));
            u.setY((Double) map.get("Uy"));
            u.setTime((Integer) map.get("Utime"));
            u.setBid((Integer) map.get("Ubid"));
            u.setS(getS((String) map.get("Us")));
            u.setProperty(getP((String) map.get("Uproperty")));
            u.setTheta(new double[]{0, 0, 0, 0, 0, 0, 0, 0});
            double[][] tmp = new double[8][8];
            for(int j = 0; j < 8; j++){
                tmp[j][j] = 1;
            }
            u.setA(tmp);
            u.setB(new double[]{0, 0, 0, 0, 0, 0, 0, 0});
            userList.add(u);
        }

        return userList;
    }
}
