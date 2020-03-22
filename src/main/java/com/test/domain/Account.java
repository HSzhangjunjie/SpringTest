package com.test.domain;

import java.io.Serializable;

/**
 * @Description:
 * @author: HandSomeMaker
 * @date: 2020/3/19 3:02
 */
public class Account implements Serializable {
    private int id;
    private double money;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}
