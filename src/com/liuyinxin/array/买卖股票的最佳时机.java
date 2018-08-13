package com.liuyinxin.array;

public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        买卖股票的最佳时机  s= new 买卖股票的最佳时机 ();

        int [] num = {1,2,3,4,0,5};
        System.out.println(
                s.maxProfit(num)
        );
    }


    public int maxProfit(int[] prices) {

        if (prices.length <= 0) return 0;

        int max = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; ++i){
            if ((prices[i] - pre) <= 0){
                pre = prices[i];
            } else { // 能获取利益
                max = Integer.max(prices[i] - pre, max);
            }
        }
        return max;
    }
}
