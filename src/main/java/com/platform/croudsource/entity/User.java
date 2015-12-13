package com.platform.croudsource.entity;

import org.springframework.stereotype.Repository;

/**
 * Created by ron on 2015/12/11.
 */
@Repository
public class User {

    private int id;
    private String name;
    private String pwd;
    private double x;
    private double y;
    private int bid;
    private double p;
    private double cor;
    private  int time;
    private String s;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getCor() {
        return cor;
    }

    public void setCor(double cor) {
        this.cor = cor;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
