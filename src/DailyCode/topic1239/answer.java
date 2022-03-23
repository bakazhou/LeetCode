package DailyCode.topic1239;

import org.junit.Test;

import java.util.*;

public class answer {
    int[] memo;
    public int maxLength(List<String> arr) {
        //预处理字符串
        List<String> doClear = new ArrayList<>();
        for (int i=0;i<arr.size();i++){
            if (check(arr.get(i))){
                doClear.add(arr.get(i));
            }
        }
        memo = new int[arr.size()];
        return dfs(doClear,memo.length-1,"");
    }
    public int dfs(List<String> arr,int index,String cur){
        if (index==-1){
            return cur.length();
        }
        if (memo[index]!=0){
            System.out.println(cur);
            return memo[index];
        }
        int max = cur.length();
        for (int i=index;i>=0;i--){
            String str = new String(cur+arr.get(i));
            if (check(str)){
                max = Math.max(max,dfs(arr,i-1,str));
            }else {
                continue;
            }
        }
        memo[index]=max;
        return max;
    }
    public boolean check(String cur){
        Set<Character> set = new HashSet<>();
        char[] chars = cur.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (set.contains(chars[i])){
                return false;
            }else {
                set.add(chars[i]);
            }
        }
        return true;
    }


}
