package com.liuyinxin.string;

import java.util.ArrayList;

public class 数数并说 {

    public static void main(String[] args) {


        数数并说 s = new 数数并说();

        System.out.println(
                s.countAndSay(3)
        );
    }

    public String countAndSay(int n) {

        StringBuilder r = new StringBuilder("1");
        StringBuilder next;
        for (int i = 1; i < n; i++){
            char start;
            int num;
            next = new StringBuilder();
            for (int j = 0; j < r.length(); ++j){
                start = r.charAt(j);
                num = j + 1;
                while (num < r.length() && start == r.charAt(num)) num ++;
                next.append(num - j);
                next.append(start - '0');
                j = num - 1;
            }
            r = next;
        }

        return r.toString();
    }
}
