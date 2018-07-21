package com.liuyinxin.array;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。

 将图像顺时针旋转 90 度。

 说明：

 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 示例 1:

 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 示例 2:

 给定 matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]
 */
public class RotateMatrix {

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();

//        int[][] arr = {
//                { 5, 1, 9,11},
//                { 2, 4, 8,10},
//                 {13, 3, 6, 7},
//                 {15,14,12,16}
//        };
        int[][] arr = {
                {1,2},
                {3,4}

        };

        rm.rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public void rotate(int[][] matrix) {

        int len = matrix.length;
        if (matrix.length <= 1) return;

        int level = len / 2;
        int pre;
        int x, y, tmp;
        int h = len - 1;
        for (int l = 0; l < level; ++l){

            int last = len - l - 1;

            for (int i = l; i < last; ++i){
                x = l;
                y = i;
                pre = matrix[x][y];
                for (int j = 0; j < 4; ++j){
                    tmp = x;
                    x = y;
                    y = -1 * tmp + h;
                    tmp = matrix[x][y];
                    matrix[x][y] = pre;
                    pre = tmp;
                }

            }
        }
    }
}
