package com.liuyinxin.number;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-15
 * @Time: 16:10
 * do the best
 */
public class 整数转罗马数字_12 {

    char[] ten = {'I', 'I', 'X', 'C', 'M'};
    char[] five = {'V', 'V', 'L', 'D'};

    public String intToRoman(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            int n = arr[i] - '0';
            if (n == 9) {
                sb.append(ten[arr.length - i]);
                sb.append(ten[arr.length - i + 1]);
            } else if (n == 4) {
                sb.append(ten[arr.length - i]);
                sb.append(five[arr.length - i]);
            }else {
                if (n >= 5) {
                    sb.append(five[arr.length - i]);
                    n -= 5; }
                while (n > 0) {
                    sb.append(ten[arr.length - i]);
                    n--;
                }
            }
        }
        return sb.toString();
    }
}
