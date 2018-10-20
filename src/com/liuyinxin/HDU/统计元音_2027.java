package com.liuyinxin.HDU;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class 统计元音_2027 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t -- > 0){
            String line = in.nextLine();
            char[] lineArr = line.toCharArray();
            int[] charMap = new int[27];

            for (char aLineArr : lineArr) {
                if (Character.isLowerCase(aLineArr) || Character.isUpperCase(aLineArr))
                    charMap[aLineArr - 'a']+=1;
            }
            System.out.println("a:" + charMap[0]);
            System.out.println("e:" + charMap['e' - 'a']);
            System.out.println("i:" + charMap['i' - 'a']);
            System.out.println("o:" + charMap['o' - 'a']);
            System.out.println("u:" + charMap['u' - 'a']);
            if (t > 0) {
                System.out.println();
            }
        }
    }
}
