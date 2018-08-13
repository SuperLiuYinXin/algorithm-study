package com.liuyinxin;

/**
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。

 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。

 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。

 投影就像影子，将三维形体映射到一个二维平面上。

 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。

 返回所有三个投影的总面积。

 输入：[[1,0],[0,2]]
 输出：8
 示例 4：

 输入：[[1,1,1],[1,0,1],[1,1,1]]
 输出：14
 示例 5：

 输入：[[2,2,2],[2,1,2],[2,2,2]]
 输出：21

 */
public class 三维形体投影面积 {

    public static void main(String[] args) {
        三维形体投影面积 s = new 三维形体投影面积 ();

        int[][] a = {
//                {2,2,2},{2,1,2},{2,2,2}
//                {1, 0}, {0,2}
//                {1,1,1}, {1,0,1}, {1,1,1}
                {}
        };
        System.out.println(
                s.projectionArea(a)
        );


    }

    public int projectionArea(int[][] grid) {
        int front = 0;
        int top = 0;
        int left = 0;
        // 顶部 不为 0
        // 正面  y取最值
        // 侧面  x行取最值

        int maxLeft = 0;
        int[] leftRow = null;
        int[] row = null;
        for (int x = 0; x < grid.length; x++){
            // 初始化
            if (leftRow == null || grid[x].length > maxLeft){
                maxLeft = grid[x].length;
                if (leftRow == null){
                    leftRow = new int[maxLeft];
                } else {
                    int[] tmpRow = new int[maxLeft];
                    System.arraycopy(leftRow, 0, tmpRow, 0, leftRow.length);
                    leftRow = tmpRow;
                }
            }

            row = grid[x];
            int frontMax = 0;
            for (int y = 0; y < row.length; y++){
                // 顶
                if (row[y] > 0){
                    ++top;
                }
                // 侧
                leftRow[y] = Math.max(leftRow[y], row[y]);
                // 正面
                frontMax = Math.max(frontMax, row[y]);
            }
            front += frontMax;
        }

        if (top == 0){
            return 0;
        }

        for (int i = 0; i < leftRow.length; ++i){
            left += leftRow[i];
        }

        return top + front + left;
    }
}
