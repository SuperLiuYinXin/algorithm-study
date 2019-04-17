package com.liuyinxin.array;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-17
 * @time: 12:59
 * do the best
 */
public class 前递后减的数组就最大值 {

    int findMax(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        if (arr.length == 2) return arr[0] > arr[1] ? 0 : 1;

        int l  = 0;
        int r =  arr.length - 1;
        int mid = -1;
        // [l, r]
        while (l < r) {
            mid = l + (r - l) / 2;
            System.out.println("l = " +l + " r = " +  r + " mid= " + mid);
            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return mid;
            } // up
            else if (arr[mid - 1] < arr[mid]) {
                l = mid + 1;
            } // down
            else if (arr[mid + 1] < arr[mid]) {
                r = mid - 1;
            }
        }
        return r + (r - l) >> 2;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        前递后减的数组就最大值 s = new 前递后减的数组就最大值();
//        System.out.println(s.findMax(arr));
//        arr = new int[]{1, 2, 1};
//        System.out.println(s.findMax(arr));

        arr = new int[]{0, 1, -1,-2, -3, -4, -5};
//        arr = new int[]{1, 2, 3, 4, 5, -1};
        System.out.println(s.findMax(arr));
    }


}
