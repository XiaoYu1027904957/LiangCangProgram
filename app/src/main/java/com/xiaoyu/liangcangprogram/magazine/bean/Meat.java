package com.xiaoyu.liangcangprogram.magazine.bean;

/**
 * 杂志的mean对象解析数据
 */

public class Meat {

    /**
     * status : 0
     * server_time : 2017-01-04 15:56:16
     * account_id : 0
     * cost : 0.237965
     * errdata : null
     * errmsg :
     * {"account_id":0,"cost":0.178993,"errmsg":"","server_time":"2017-01-04 16:36:08","status":0}
     */

    private int status;
    private String server_time;
    private int account_id;
    private double cost;
    private String errdata;
    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrdata() {
        return errdata;
    }

    public void setErrdata(String errdata) {
        this.errdata = errdata;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getServer_time() {
        return server_time;
    }

    public void setServer_time(String server_time) {
        this.server_time = server_time;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}