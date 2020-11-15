package com.seed.mybatisRedis.entity;

public class Demo {
    private String c1;

    private Integer c2;

    private Integer c2Up;

    public Demo(String c1, Integer c2, Integer c2Up) {
        this.c1 = c1;
        this.c2 = c2;
        this.c2Up = c2Up;
    }

    public Demo() {
        super();
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    public Integer getC2Up() {
        return c2Up;
    }

    public void setC2Up(Integer c2Up) {
        this.c2Up = c2Up;
    }
}