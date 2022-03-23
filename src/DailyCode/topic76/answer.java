package DailyCode.topic76;

import java.util.HashMap;
import java.util.Map;

public class answer {
    public String minWindow(String s, String t) {
        //1 <= s.length, t.length <= 105
        char[] chars = s.toCharArray();
        char[] target = t.toCharArray();
        String ans="";
        Map<Character,Integer> map = new HashMap<>();//用来判断是否包含字符
        Map<Character,Integer> tmap = new HashMap<>();//用来判断是否包含字符
        for (int i=0;i<target.length;i++){
            if (tmap.containsKey(target[i])) tmap.put(target[i],tmap.get(target[i])+1);
            else tmap.put(target[i],1);
        }
        int left=0,right=0,slength=s.length();
        while (left<=right && right<slength){
            if (map.containsKey(chars[right])) map.put(chars[right],map.get(chars[right])+1);
            else map.put(chars[right],1);
            //已经包含全部t中字符
            boolean flag = check(target,map,tmap);
            while (flag){
                if (ans.equals("") || right+1-left<=ans.length()) ans=s.substring(left,right+1);
                    System.out.println(ans);
                if (map.get(chars[left])==1) map.remove(chars[left]);
                else if (map.get(chars[left])>1) map.put(chars[left],map.get(chars[left])-1);
                if (tmap.containsKey(chars[left])){//tmap中包含left处的字符
                    if (!map.containsKey(chars[left]) || map.get(chars[left])<tmap.get(chars[left])){
                        left++;
                         break;
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }
    public boolean check(char[] target,Map<Character,Integer> map,Map<Character,Integer> tmap){
        int tlength = target.length;
        boolean flag = true;
        for (int i=0;i<tlength;i++){
            if (!map.containsKey(target[i]) || map.get(target[i])<tmap.get(target[i])){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        String a  = "A";
        System.out.println(a.substring(0,1));
    }
}
