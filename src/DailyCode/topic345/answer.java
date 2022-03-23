package DailyCode.topic345;

import java.util.HashSet;
import java.util.Set;

public class answer {
    char[] chars;
    public String reverseVowels(String s) {
        chars = s.toLowerCase().toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int low = 0,high = s.length()-1;
        while (low<high){
            while (low<s.length()-1 && !set.contains(chars[low])){
                low++;
            }
            while (high>=0 && set.contains(chars[high])){
                high--;
            }
            if (low<high){
                swap(low,high);
                System.out.println(new String(chars));
                low++;
                high--;
            }
        }
        return new String(chars);
    }
    public void swap(int low,int high){
        char tem = chars[low];
        chars[low]=chars[high];
        chars[high]=tem;
    }
}
