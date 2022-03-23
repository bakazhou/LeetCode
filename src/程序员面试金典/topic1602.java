package ����Ա���Խ��;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��12�� 14:35
 **/
class WordsFrequency {
    Map<String,Integer> map;
    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (int i=0;i<book.length;i++){
            map.put(book[i],map.getOrDefault(book[i],0)+1);
        }
    }

    public int get(String word) {
        return map.containsKey(word)?map.get(word):0;
    }
}
public class topic1602 {
}
