package DailyCode.topic524;

import java.util.*;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        //字典序排序
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                } else {
                    return word1.compareTo(word2);
                }
            }
        });

        char[] chars = s.toCharArray();
        int length = dictionary.size();
        List<String> list = new ArrayList<>();
        for (int i=0;i<length;i++){
            String string = dictionary.get(i);
            char[] stringChar = string.toCharArray();
            int sBegin=0,stringBegin=0;
            while (sBegin<s.length() && stringBegin<string.length()){
                if (chars[sBegin]==stringChar[stringBegin]){
                    sBegin++;
                    stringBegin++;
                }else {
                    sBegin++;
                }
            }
            if (stringBegin==string.length()){
                list.add(string);
            }
        }
        if (list.size()==0){
            return "";
        }
        String ans = list.get(0);
        for (int i=1;i<list.size();i++){
            if (list.get(i).length()>ans.length()){
                ans = list.get(i);
            }
        }
        return ans;
    }

//    public String findLongestWord(String s, List<String> dictionary) {
//        char[] chars = s.toCharArray();
//        Map<Character,Integer> map = new HashMap<>();
//        int n = s.length();
//        for (int i=0;i<n;i++){
//            if (!map.containsKey(chars[i])){
//                map.put(chars[i],1);
//            }else {
//                map.put(chars[i],map.get(chars[i])+1);
//            }
//        }
//        int length = dictionary.size();
//        List<String> list = new ArrayList<>();
//        for (int i=0;i<length;i++){
//            String s1 = dictionary.get(i);
//            char[] chars1 = s1.toCharArray();
//            Map<Character,Integer> rember = new HashMap<>();
//            for (int j=0;j<s1.length();j++){
//                if (!rember.containsKey(chars[j])){
//                    rember.put(chars[j],1);
//                }else {
//                    rember.put(chars[j],rember.get(chars[j])+1);
//                }
//            }
//            boolean flag = true;
//            for (Character key : map.keySet()){
//                if (!rember.containsKey(key)){//不存在对应的字符
//                    flag = false;
//                    break;
//                }
//                if (rember.get(key)<map.get(key)){//缺少对应字符
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag){
//                list.add(s1);
//            }
//        }
//        Collections.sort(list);
//        System.out.println(list);
//        return "";
//    }
}
