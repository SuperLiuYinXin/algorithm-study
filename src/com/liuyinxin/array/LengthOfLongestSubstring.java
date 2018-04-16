package com.liuyinxin.array;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args){
        LengthOfLongestSubstring demo = new LengthOfLongestSubstring();
        String test=  "jxdlnaaig";
//        String test=  "dvdf";
//        String test = "bbbbbbbbbbb";
//        String test = "wobgrovw";
//        String result = demo.lengthOfLongestSubstring(test);
        Integer result = demo.lengthOfLongestSubstring(test);
        System.out.println(result);
    }


    public int lengthOfLongestSubstring(String s){
        assert s != null;
        if (s.length() <= 1) return s.length();
        int maxLength = 0;
        int curLength = 0;
        int maxStart = 0;
        int curStart = 0;
        Map<Character, Integer> cMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++){
            Character chr = s.charAt(i);
            if (cMap.containsKey(chr)){ // 如果存在这个key，找出来key的位置
                int p = cMap.get(chr);
                if (p < curStart){
                    ++curLength;
                } else {
                    curLength = i - p;
                    curStart = p + 1;
                }
            } else { // 不包含这个字符
                ++curLength;
            }
            cMap.put(chr, i);
//            System.out.println("第 " + (i +1) + " 次 curStart:[" + curStart + "] curLength [" + curLength +"]" + s.substring(curStart,curStart + curLength));
            if (curLength > maxLength){
                maxLength = curLength;
                maxStart = curStart;
                System.out.println("第 " + (i + 1) + " 次时候赋值给了最值");
            }
        }
        return maxLength;
    }

    // 使用动态规划的思路
//    public int lengthOfLongestSubstring(String s){
//        assert s != null;
//        if (s.length() <= 1) return s.length(); //当长度为1的时候，子串就他一个
//        int curStart = 0;   //当前最大的开始位置
//        int maxStart = 0;   //全局最大的开始位置
//        int maxLength = 0;  //全局最大的长度
//        int curLength = 0;  //当前最大的长度
//        Map<Character, Integer> cMap = new HashMap<>(s.length());
//        for (int i = 0; i < s.length(); i++){
//            Character chr = s.charAt(i);
//            if (!cMap.containsKey(chr)){ // 如果没有这个字符
//                cMap.put(chr,i); // 放进去
//                curLength++; // 长度自增
//            } else {  //如果冲突了，找到最长的pre
//                //如果有的话,说明已经重复,开始更换,找到上一个重复的位置，上一个位置开始 + 1到当前字符为暂时的无重复段
//                int pre = cMap.get(chr) + 1; // 获取前一个的位置
//                for (int tmpPre = pre; tmpPre < i ; ++tmpPre){
////                    if (cMap.containsKey(s.charAt(tmpPre))){
//                    if(cMap.get(s.charAt(tmpPre)) > tmpPre){
//                        pre++;
////                        tmpPre = pre + 1;
//                    };
////                    }
//                }
//                cMap.put(chr, i); // 更新字符的记录
//                curStart = pre; // 设定前一个的位置
//                curLength = i - pre + 1; // 设定开始的长度
//            }
//            System.out.println("第 " + i + " 次 :[" + curStart + "] [" + curLength +"]" + s.substring(curStart,curStart + curLength));
//            if (curLength > maxLength){ //记录下最长的无重复段
//                System.out.println("第 " + i + " 次时候赋值给了最值");
//                maxLength = curLength;
//                maxStart = curStart;
//            }
//        }
////        return s.substring(maxStart, maxStart + maxLength);
//        return maxLength;
//    }

}
