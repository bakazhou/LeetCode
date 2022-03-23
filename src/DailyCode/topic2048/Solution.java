package DailyCode.topic2048;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月10日 21:59
 **/
public class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i=n+1;i<=Integer.MAX_VALUE;i++){
            if (check(i)){
                return i;
            }
        }
        return n;
    }
    public boolean check(int n){
        char[] chars = Integer.toString(n).toCharArray();
        Set<Integer> set = new HashSet<>();
        int[] mem = new int[10];
        for (int i=0;i<chars.length;i++){
            //不能出现0
            if (mem[chars[i]-48]+1 > (chars[i]-48)){
                return false;
            }else {
                set.add(chars[i]-48);
                mem[chars[i]-48]++;
            }
        }
        for (int key : set){
            if (key != mem[key]){
                return false;
            }
        }
        return true;
    }
}
