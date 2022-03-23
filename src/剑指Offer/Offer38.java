package 剑指Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer38 {
    Set<String> set = new HashSet<>();
    List<String> ans = new ArrayList<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];
        backtrack(chars,used,"");
        String[] strings = new String[ans.size()];
        for (int i=0;i<ans.size();i++){
            strings[i]=ans.get(i);
        }
        return strings;
    }
    public void backtrack(char[] chars,boolean[] used,String sb){
        if (sb.length()==chars.length){
            if (!set.contains(sb.toString())){
                ans.add(sb.toString());
            }
            set.add(sb.toString());
            return;
        }
        for (int i=0;i<chars.length;i++){
            if (!used[i]){
                sb+=chars[i];
                used[i]=true;
                backtrack(chars,used,sb);
                used[i]=false;
                sb=sb.substring(0,sb.length()-1);
            }
        }
    }

}
