package com.example;
/**
 * Created by ellen on 2017/3/7.
 * 写一个Observer模式的实现，并对代码加以解释
 */

public class QuestionOne {
    public static  void main(String ... args){
        MyObservable mObservable = new MyObservable();//实例化被观察者对象
        mObservable.addObserver(new MyObserver());//给mObservable这个被观察者添加观察者，允许添加多個观察者
        mObservable.setData(11);
        mObservable.setData(22);
        mObservable.setData(7569);
    }
}