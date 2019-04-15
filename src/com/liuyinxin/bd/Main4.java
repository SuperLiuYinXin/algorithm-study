package com.liuyinxin.bd;

import java.util.*;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-14
 * @Time: 10:02
 * do the best
 */
public class Main4 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Map<String, Integer> curMap = new HashMap<>();
        Map<String, Integer> max = new HashMap<>();

        Set<String>  zS = new HashSet<>(), nextS = new HashSet<>();
        Integer num;
        while (t-- > 0) {
            int n = in.nextInt();
            int z = 0, x, y;
            for (int i = 0; i < n; ++i) {
                z = in.nextInt();
                for (int j = 0; j < z; ++j) {
                    String s = in.nextInt() + " " + in.nextInt();
                    if (i == 0)
                        zS.add(s);
                    else
                        nextS.add(s);
                }
                if (!nextS.isEmpty()) {
                    for (String s: nextS) {
                        if (!zS.contains(s)) {
                            num = curMap.get(s);
                            Integer curMax = max.get(s);
                            if (curMax == null) {
                                continue;
                            }
                            max.put(s, num == null ? 1 : Math.max(num, curMax) );
                        }
                    }
                    zS = nextS;
                }
            }
        }

        int maxNum = 0;
        for(Map.Entry<String, Integer> s: max.entrySet()) {
            maxNum = Math.max(maxNum, s.getValue());
        }
        System.out.println(maxNum);
    }
}
