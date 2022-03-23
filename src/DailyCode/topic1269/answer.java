package DailyCode.topic1269;

import java.util.HashSet;
import java.util.Set;

public class answer {
    int sum = 0;
    Set<String> set = new HashSet<>();
    public int numWays(int steps, int arrLen) {
        dfs(steps,arrLen,0,0,"");
        return sum;
    }
    public void dfs(int steps, int arrLen,int cur,int location,String road){
        if (location>steps-cur) return;
        if (cur!=0) road+=Integer.toString(location);
        if (cur == steps) {
            if (!set.contains(road)) {
                if (location == 0){
                    sum++;
                }
            }else set.add(road);
            return;
        }
        for (int i=-1;i<=1;i++){
            if (location+i>=0 && location+i<arrLen) dfs(steps, arrLen, cur+1, location+i,road);
        }
    }
}
