package DailyCode.topic877;

import java.util.HashSet;
import java.util.Set;

public class answer {
    boolean flag = false;
    Set<String> set;
    public boolean stoneGame(int[] piles) {
        set = new HashSet<>();
        dfs(piles,piles.length-1,0,0,0,0);
        return flag;
    }
    public void dfs(int[] piles,int right,int left,int Lee,int Alex,int around){
        String s = String.valueOf(Lee)+"+"+String.valueOf(Alex)+"+"+String.valueOf(around);//当前回合Alex得分和Lee得分
        if (set.contains(s)){
            return;
        }
        set.add(s);
        if (around==piles.length){
            if (Alex>Lee){
                flag=true;
            }
            return;
        }
        if (around%2==0){//around为双数归Alex
            dfs(piles, right, left+1, Lee, Alex+piles[left], around+1);//选左边
            dfs(piles, right-1, left, Lee, Alex+piles[right], around+1);//选右边
        }else {
            dfs(piles, right, left+1, Lee+piles[left], Alex, around+1);//选左边
            dfs(piles, right-1, left, Lee+piles[right], Alex, around+1);
        }

    }
}
