package DailyCode.topic211;

import java.net.DatagramPacket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WordDictionary {
    /*
    按照单词长度进行set的分类,优化查找速度
     */
    Map<Integer,Set<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int leng = word.length();
        if (!map.containsKey(leng)){
            Set<String> dictionary = new HashSet<>();
            dictionary.add(word);
            map.put(leng,dictionary);
        }else {
            Set<String> dictionary = map.get(leng);
            dictionary.add(word);
        }
    }

    public boolean search(String word) {
        int leng = word.length();
        Set<String> dictionary = map.get(word.length());
        if (dictionary == null){
            return false;
        }
        if (dictionary.contains(word)){
            return true;
        }
        char[] chars = word.toCharArray();
        for (String key : dictionary){
            boolean flag = true;
            for (int i=0;i<chars.length;i++){
                if (chars[i]=='.'){
                    continue;
                }else {
                    if (chars[i]!=key.charAt(i)){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */