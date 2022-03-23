package DailyCode.topic299;

import java.util.*;

class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        char[] s1 = secret.toCharArray();
        char[] g1 = guess.toCharArray();
        int bulls = 0;//记录公牛数字，即位置和数字都猜对了的数字
        int cows = 0;//记录奶牛数字，属于数字猜对了但是位置不对
        Map<Character, HashSet<Integer>> s = new HashMap<>();//字符和其对应的下标
        Map<Character, HashSet<Integer>> g = new HashMap<>();
        for (int i=0;i<s1.length;i++){
            //原secret中的对应关系
            if (!s.containsKey(s1[i])){
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                s.put(s1[i],set);
            }else {
                s.get(s1[i]).add(i);
            }
            //guess中的对应关系
            if (!g.containsKey(g1[i])){
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                g.put(g1[i],set);
            }else {
                g.get(g1[i]).add(i);
            }
        }
        Set<Character> set = g.keySet();
        for (Character key : set){
            if (!s.containsKey(key)){
                continue;
            }
            HashSet<Integer> index = g.get(key);//guess
            HashSet<Integer> hashSet = s.get(key);//scret
            int used = 0;
            for (Integer i : index){
                if (hashSet.contains(i)){//数字猜对且下标也对
                    used++;
                    bulls++;
                }
            }
            int notUsed = hashSet.size()-used;
            if (notUsed > 0){
                cows += Math.min(notUsed,index.size()-used);
            }
        }
        sb.append(bulls);
        sb.append('A');
        sb.append(cows);
        sb.append('B');
        return sb.toString();
    }
}