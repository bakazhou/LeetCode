package DailyCode.topic650;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

public class Solution {
    int oper = 1001;
    public int minSteps(int n) {
        if (n<=1){
            return 0;
        }
        dfs(new StringBuilder("A"),n,"",0);
        return oper;
    }

    public void dfs(StringBuilder sb,int n,String cur,int op){
        if (sb.length()==n){
            oper = Math.min(op,oper);
        }
        if (sb.length()>=n){
            return;
        }
        if (cur.equals("")){
            dfs(sb, n, sb.toString(), op+1);
        }
        if (!cur.equals(sb.toString())){
            dfs(sb, n, sb.toString(), op+1);
        }
        dfs(sb.append(cur), n, cur, op+1);
    }
}
