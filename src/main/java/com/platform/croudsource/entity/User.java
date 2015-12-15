package com.platform.croudsource.entity;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ron on 2015/12/11.
 */
@Repository
public class User implements Serializable {

    private int id;
    private String name;
    private String pwd;
    private double x;
    private double y;
    private int bid;
    private double p;    //????????????
    private int time;	//?????¡À??
    private ArrayList<Integer> s;  //??????
    private double[] theta = {0, 0, 0, 0, 0, 0, 0, 0};
    private double[][] a = new double[8][8];  //matrix A
    private double[] b = {0, 0, 0, 0, 0, 0, 0, 0}; //matrix b
    private double[] property = {0, 0, 0, 0, 0, 0, 0, 0};

    public double[] getProperty() {
        return property;
    }
    public void setProperty(double[] property) {
        this.property = property;
    }
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<Integer> getS() {
        return s;
    }
    public void setS(ArrayList<Integer> s) {
        this.s = s;
    }
    public double[] getTheta() {
        return theta;
    }
    public void setTheta(double[] theta) {
        this.theta = theta;
    }
    public double[][] getA() {
        return a;
    }
    public void setA(double[][] a) {
        this.a = a;
    }
    public double[] getB() {
        return b;
    }
    public void setB(double[] b) {
        this.b = b;
    }
}

