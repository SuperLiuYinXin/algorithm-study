package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 密码_2043 {

    public static int debug = 1;
    public static InputStream is = System.in;
    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/HDU/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(is);

        int t = in.nextInt();
        in.nextLine();
        while (t--> 0){
            int[] check = new int[4];
            String pw = in.nextLine();
            if (pw.length() < 8 || pw.length() > 16)
                System.out.println("NO");
            else {
                char[] pwArr = pw.toCharArray();
                int count = 0;
                for (int j = 0; j < pwArr.length && count < 3; ++j) {
                    char w = pwArr[j];
                    for (int i = 0; i < check.length && count < 3; ++i) {
                        if (check[i] == 1) continue;
                        switch (i){
                            case 0:
                                if (Character.isUpperCase(w)){
                                    ++count;
                                    check[0] = 1;
                                }
                                break;
                            case 1:
                                if (Character.isLowerCase(w)){
                                    ++count;
                                    check[1] = 1;
                                }
                                break;
                            case 2:
                                if (Character.isDigit(w)){
                                    ++count;
                                    check[2] = 1;
                                }
                                break;
                            case 3:
                                if ( w == '~' || w == '!' || w == '@' || w == '#' || w == '$' ||
                                        w == '%' || w == '^' ){
                                    ++count;
                                    check[3] = 1;
                                }
                                break;
                            default: break;
                        }
                    }
                }
                System.out.println( count >= 3 ? "YES" : "NO");
            }
        }

    }

}
