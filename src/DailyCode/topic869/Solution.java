package DailyCode.topic869;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    boolean flag = false;
    public boolean reorderedPowerOf2(int n) {
        if (n==1){
            return true;
        }
        String string = Integer.toString(n);
        char[] chars = string.toCharArray();
        boolean[] visited = new boolean[chars.length];
        dfs(chars,"",visited);
        return flag;
    }
    public void dfs(char[] chars,String num,boolean[] visited){
        if (num.length()!=0 && num.charAt(0)=='0'){
            return;
        }
        if (num.length() == chars.length){
            if (isValid(num)){
                flag = true;
            }
            return;
        }
        for (int i=0;i<chars.length;i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(chars,num+chars[i],visited);
                visited[i] = false;
            }
        }
    }
    public boolean isValid(String str){
        int num = Integer.parseInt(str);
        String s = Integer.toString(num, 2);
        char[] chars = s.toCharArray();
        for (int i=1;i<chars.length;i++){
            if (chars[i]!='0'){
                return false;
            }
        }
        System.out.println(str);
        return true;
    }
}
