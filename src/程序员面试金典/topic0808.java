package 程序员面试金典;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 15:05
 **/
public class topic0808 {
    Set<String> set = new HashSet<>();
    List<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] flag = new boolean[chars.length];
        dfs(chars,"",S,flag);
        String[] ans = new String[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void dfs(char[] chars,String cur,String S,boolean[] flag){
        if (cur.length() == S.length()){
            if (!set.contains(cur)){
                set.add(cur);
                list.add(cur);
            }
            return;
        }
        for (int i=0;i<chars.length;i++){
            if (!flag[i]){
                flag[i] = true;
                String s = new String(cur);
                dfs(chars, s+chars[i], S, flag);
                flag[i] = false;
            }
        }
    }
}
