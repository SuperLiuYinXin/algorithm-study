package com.liuyinxin;

import java.util.*;

/**
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 */
public class 查找和替换模式_890 {

    public static void main(String[] args) {
        查找和替换模式_890 s = new 查找和替换模式_890();
        String[] strings = {"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println(
                s.findAndReplacePattern(strings, "abb")
        );
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        LinkedList<String> result = new LinkedList<>();
        Map<Character, Character> charsMap = new HashMap<>();
        char[] charArr;
        char[] patternArr = pattern.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        boolean isAll;
        for (String word: words){
            if (word.length() != pattern.length()) continue;
            charsMap.clear();
            set.clear();
            isAll = true;
            charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; ++i){
                if (charsMap.containsKey(patternArr[i])){
                    if (charsMap.get(patternArr[i]) != charArr[i]){
                        isAll = false;
                        break;
                    }
                } else {
                    // 包含了，就不是单射了
                    if (set.contains(charArr[i])){
                        isAll = false;
                        break;
                    } else {
                        charsMap.put(patternArr[i],charArr[i]);
                        set.add(charArr[i]);
                    }
                }
            }
            if (isAll){
                result.add(word);
            }
        }
        return result;
    }
}
