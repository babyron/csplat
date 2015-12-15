package com.platform.croudsource.dao;

import com.platform.croudsource.entity.Mission;
import com.sun.corba.se.impl.protocol.MinimalServantCacheLocalCRDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    private void appendA(StringBuilder sb, Object a){
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

        List<Mission> missionList = new ArrayList<Mission>();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        for(Map<String, Object> map:list){
            Mission mission = new Mission();
            mission.setId((Integer) map.get("Tid"));
            mission.setName((String) map.get("Tname"));
            mission.setPay((Double) map.get("Tpay"));
            mission.setType(Integer.parseInt((String) map.get("Ttype")));
            mission.setX((Double) map.get("Tx"));
            mission.setY((Double) map.get("Ty"));
            mission.setTime((Integer) map.get("Ttime"));
            mission.setTimes((Integer) map.get("Ttimes"));
            mission.setValue((Integer) map.get("Tvalue"));
            mission.setProperty(getP((String) map.get("Tproperty")));
            mission.setBudget(1000);
            missionList.add(mission);
        }

        return missionList;
    }

    private double[] getP(String s){
        String ss[] = s.trim().split(" ");
        double p[] = new double[8];
        for(int i = 0; i < 8; i++){
            p[i] = Double.parseDouble(ss[i]);
        }
        return p;
    }

    public Mission getMission(int id){
        String sql = "select * from t_mission where Tid = ?";
        System.out.println(id);

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{id});

        Mission mission = new Mission();
        Map<String, Object> map = list.get(0);
        mission.setId((Integer) map.get("Tid"));
        mission.setName((String) map.get("Tname"));
        mission.setPay((Double) map.get("Tpay"));
        mission.setType(Integer.parseInt((String) map.get("Ttype")));
        mission.setX((Double) map.get("Tx"));
        mission.setY((Double) map.get("Ty"));
        mission.setTime((Integer) map.get("Ttime"));
        mission.setTimes((Integer) map.get("Ttimes"));
        mission.setValue((Integer) map.get("Tvalue"));
        mission.setProperty(getP((String) map.get("Tproperty")));
        mission.setBudget(1000);
        return mission;
    }

}
