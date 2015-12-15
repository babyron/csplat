package com.platform.croudsource.dao;

import com.platform.croudsource.entity.Mission;
import com.platform.croudsource.entity.User;
import com.platform.croudsource.util.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println("property:" + sb.toString());
        return sb.toString();
    }

    @Transactional
    public int insertMission(Mission mission){
        String sql = "insert into t_mission(Tname, Tx, Ty, Ttimes, Ttime, Tpay, Ttype, " +
                "Tvalue, Tproperty, Tbudget, TremainBudget, Tsuccess, Tfailure) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object args[] = new Object[]{
                mission.getName(),
                mission.getX(),
                mission.getY(),
                mission.getTimes(),
                mission.getTime(),
                mission.getPay(),
                mission.getType(),
                mission.getValue(),
                getProperty(mission),
                1000.0,
                1000.0,
                0,
                0
        };
        return jdbcTemplate.update(sql, args);
    }

    public int getMissionCount(){
        String sql = "select count(*) from t_mission";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void setMission(Mission mission, Map<String, Object> map){
        mission.setId((Integer) map.get("Tid"));
        mission.setName((String) map.get("Tname"));
        mission.setPay((Double) map.get("Tpay"));
        mission.setType(Integer.parseInt((String) map.get("Ttype")));
        mission.setX((Double) map.get("Tx"));
        mission.setY((Double) map.get("Ty"));
        mission.setTime((Integer) map.get("Ttime"));
        mission.setTimes((Integer) map.get("Ttimes"));
        mission.setValue((Integer) map.get("Tvalue"));
        mission.setProperty(ParseUtil.strToDou((String) map.get("Tproperty")));
        mission.setBudget((Double) map.get("Tbudget"));
        mission.setRemainbudget((Double) map.get("TremainBudget"));
        mission.setSuccess((Integer) map.get("Tsuccess"));
        mission.setFailure((Integer) map.get("Tfailure"));
    }

    public ArrayList<Mission> getMissions(){
        String sql = "select * from t_mission";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        ArrayList<Mission> missionList = new ArrayList<Mission>();
        for(Map<String, Object> map:list){
            Mission mission = new Mission();
            setMission(mission, map);
            missionList.add(mission);
        }

        return missionList;
    }

    public Mission getMission(int id){
        String sql = "select * from t_mission where Tid = ?";
        System.out.println(id);

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{id});

        Mission mission = new Mission();
        Map<String, Object> map = list.get(0);
        setMission(mission, map);
        return mission;
    }

    public ArrayList<Mission> getMissionByType(int type){
        String sql = "select * from t_mission where Ttype = ?";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{type});

        ArrayList<Mission> missionList = new ArrayList<Mission>();
        for(Map<String, Object> map:list){
            Mission mission = new Mission();
            setMission(mission, map);
            missionList.add(mission);
        }

        return missionList;
    }

    @Transactional
    public void deleteMission(int id){
        String sql = "delete from t_mission where Tid = ?";

        jdbcTemplate.update(sql, new Object[]{id});
    }


    @Transactional
    public void updateBudget(List<Mission> missionList) {
        String sql = "update t_mission set Tbudget = ?, TremainBudget = ?, Tsuccess = ?, Tfailure = ? where Tid = ?";
        for (Mission mission : missionList) {
            jdbcTemplate.update(sql, new Object[]
                    {mission.getBudget(),
                            mission.getRemainbudget(),
                            mission.getSuccess(),
                            mission.getFailure(),
                            mission.getId()});
        }
    }
}
