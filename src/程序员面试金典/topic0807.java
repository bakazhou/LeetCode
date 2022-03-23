package ����Ա���Խ��;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��13�� 14:18
 **/
public class topic0807 {
    List<String> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public String[] permutation(String S) {
        boolean[] flag = new boolean[S.length()];
        dfs(S,flag,"");
        String[] ans = new String[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void dfs(String s,boolean[] flag,String cur){
        if (cur.length() == s.length()){
            if (!set.contains(cur)){
                list.add(cur);
                set.add(cur);
            }
            return;
        }
        for (int i=0;i<flag.length;i++){
            if (!flag[i]){
                flag[i] = true;
                dfs(s,flag,cur+s.charAt(i));
                flag[i] = false;
            }
        }
    }
}
