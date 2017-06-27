package com.example;

import java.util.Observable;

/**
 *  *Created by ellen on 17-3-7.
 * 一个简单的被观察者类
 * */

public class MyObservable extends Observable {
    int data = 0;

    public void setData(int data) {
        this.data = data;
        this.setChanged();// 标记此 Observable对象为已改变的对象
        this.notifyObservers();// 通知所有的观察者
    }
}
