package com.liuyinxin;


public class Main {

    public static void main(String[] args){
        ThreadLocal<String> s = new ThreadLocal<>();
        s.set("Hello World");
        s.get();

    }
}
