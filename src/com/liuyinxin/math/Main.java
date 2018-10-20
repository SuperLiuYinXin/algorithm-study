package com.liuyinxin.math;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 输入一个十进制数N，将它转换成R进制数输出。
 Input
 输入数据包含多个测试实例，每个测试实例包含两个整数N(32位整数)和R（2<=R<=16, R<>10）。
 Output
 为每个测试实例输出转换后的数，每个输出占一行。如果R大于10，则对应的数字规则参考16进制（比如，10用A表示，等等）。
 Sample Input
 7 2
 23 12
 -4 3
 Sample Output
 111
 1B
 -11
 */
public class Main {

    public static void main(String[] args) {
        Main s = new Main();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            System.out.println(
                    s.convert(scanner.nextInt(), scanner.nextInt())
            );

        }
        scanner.close();
    }

    String convert (int number, int b) {
        if (number == 0 || b < 2) return "0";
        List<Integer> resultList = new ArrayList<>();
        int neg = number > 0 ? 1: -1;
        number = Math.abs(number);
        while (number != 0){
            int bit = number % b;
            number = number / b;
            resultList.add(bit);
        }

        StringBuilder result = new StringBuilder();
        int bit = 0;
        if (neg < 0) result.append("-");
        for (int i = resultList.size() - 1; i >= 0; --i){
            bit = resultList.get(i);
            if (bit > 9) {
                result.append((char)('A' + (bit - 10)));
            } else result.append(bit);
        }
        return result.toString();
    }

}
