package com.example;
/**
 * Created by ellen on 2017/3/7.
 * дһ��Observerģʽ��ʵ�֣����Դ�����Խ���
 */

public class QuestionOne {
    public static  void main(String ... args){
        MyObservable mObservable = new MyObservable();//ʵ�������۲��߶���
        mObservable.addObserver(new MyObserver());//��mObservable������۲�����ӹ۲��ߣ�������Ӷ����۲���
        mObservable.setData(11);
        mObservable.setData(22);
        mObservable.setData(7569);
    }
}