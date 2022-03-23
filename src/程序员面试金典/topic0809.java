package 程序员面试金典;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 13:32
 **/
public class topic0809 {
    Set<String> set;
    List<String> list;
    public List<String> generateParenthesis(int n) {
        set = new HashSet<>();
        list = new ArrayList<>();
        dfs("",0,0,n);
        return list;
    }
    public void dfs(String cur,int left,int right,int n){
        if (left == n && right == n){
            if (!set.contains(cur)){
                set.add(cur);
                list.add(cur);
            }
            return;
        }
        //左括号大于右括号,可以加左括号也可以加右括号
        if (left < n){
            StringBuilder sb = new StringBuilder(cur);
            //加左括号
            sb.append('(');
            dfs(sb.toString(),left+1,right,n);
            //左括号数量大于右括号,可以加右括号
            if (left > right){
                StringBuilder sb1 = new StringBuilder(cur);
                sb.append(')');
                dfs(sb1.toString(),left,right+1,n);
            }
        }
    }
}
