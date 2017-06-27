package com.example;

import java.util.Observable;
import java.util.Observer;
/**
 * *Created by ellen on 17-3-7.
 * 一个简单的观察者
 * */

public class MyObserver implements Observer {
    //有被观察者发生变化，自动调用对应观察者的update方法
    @Override
    public void update(Observable obj, Object arg) {
        MyObservable myObservable = (MyObservable) obj;//强制类型转换获取被观察者对象
        System.out.println("被观察者的数据data已经改变，现在的data值为："+myObservable.data);
    }
}
