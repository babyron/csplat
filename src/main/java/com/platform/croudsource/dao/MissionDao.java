package com.platform.croudsource.dao;

import com.platform.croudsource.entity.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by ron on 2015/12/9.
 */
@Repository
public class MissionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void appendA(StringBuilder sb, int a){
        sb.append(a);
        sb.append(" ");
    }

    private String getProperty(Mission mission){
        StringBuilder sb = new StringBuilder("");
        appendA(sb, mission.getA1());
        appendA(sb, mission.getA2());
        appendA(sb, mission.getA3());
        appendA(sb, mission.getA4());
        appendA(sb, mission.getA5());
        appendA(sb, mission.getA6());
        appendA(sb, mission.getA7());
        sb.append(mission.getA8());
        return sb.toString();
    }

    public int insertMission(Mission mission){
        String sql = "insert into t_mission(Tname, Tx, Ty, Ttimes, Ttime, Tpay, Ttype, " +
                "Tvalue, Tproperty) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object args[] = new Object[]{
                mission.getName(),
                mission.getX(),
                mission.getY(),
                mission.getTimes(),
                mission.getTime(),
                mission.getPay(),
                mission.getType(),
                mission.getValue(),
                getProperty(mission)
        };
        return jdbcTemplate.update(sql, args);
    }

    public int getMissionCount(){
        String sql = "select count(*) from t_mission";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Mission> getMissions(){
        String sql = "select * from t_mission";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        for(Map<String, Object> map:list){
            for(String s:map.keySet()){
                System.out.println(s);
            }
        }

        return null;
    }

}
