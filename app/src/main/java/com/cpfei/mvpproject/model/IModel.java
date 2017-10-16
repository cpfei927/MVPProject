package com.cpfei.mvpproject.model;

/**
 * Created by cpfei on 2017/10/16.
 */

public class IModel {

    public String userName;
    public String password;

    @Override
    public String toString() {
        return "IModel{" +
                "usetName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
