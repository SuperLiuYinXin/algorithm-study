package com.liuyinxin.string;

/**
 *
 *   将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *  之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 *  实现一个将字符串进行指定行数变换的函数:
 *
 *  <code>string convert(string s, int numRows); </code>
 */
public class ZConvert {

    public static void main(String[] args) {

        ZConvert zConvert = new ZConvert();
        String test= "PAYPALISHIRING";
//        String test= "ABC";
        int num = 1;

        String result = "PAHNAPLSIIGYIR";
        String r =  zConvert.convert(test,num);
        if (result.equals(r)){
            System.out.println("结果正确");
        }else {
            System.out.println(r);
        };
    }


    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= 1 || len < numRows || numRows==1){ // 如果numRows为1,那么直接返回就好
            return s;
        }
        char[] chrArr = new char[len]; //创建一个和数组一样长的空数组, 看成一个矩阵, numRows * n 的一个矩阵
        int total = 0;
        // 先处理第一行
        for (int i = 0; i < len;i+= 2*numRows-2) {
            chrArr[total++] = s.charAt(i);
        }
        // 处理中间的行
        for (int i = 1; i < numRows-1; i++){
            int time = 1;
            int cur = i;
            while (cur <len && total < len) {
                chrArr[total++] = s.charAt(cur);
                if ((time & 1) == 0) { //偶数
                    cur += 2 * i;
                } else { // 奇数
                    cur += 2 * (numRows - i) - 2;
                }
                ++time;
            }
        }
        // 处理倒数第一行
        for (int i = numRows-1; i < len && total < len; i+= 2*numRows-2) {
            chrArr[total++] = s.charAt(i);
        }
        return String.valueOf(chrArr);
    }
}
