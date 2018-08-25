package com.liuyinxin.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 杨辉三角_118 {

    public static void main(String[] args) {
        杨辉三角_118 s = new 杨辉三角_118();

        System.out.println(
                s.generate(6)
        );
    }

    public List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) return new ArrayList<>(0);

        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);

        ArrayList<Integer> row = new ArrayList<>(1), newRow;
        row.add(1);

        result.add(row);
        int cur = 1; // 第几行
        while (cur < numRows){
            newRow = new ArrayList<>(cur++);
            newRow.add(1);
            for (int i = 1; i < row.size(); ++i) {
                newRow.add( row.get(i -1) + row.get(i));
            }
            newRow.add(1);
            result.add(newRow);
            row = newRow;
        }
        return result;
    }
}
