package DailyCode.topic1583;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer,Integer> pair = new HashMap<>();//记录谁与谁配对了
        for (int[] couple : pairs){
            pair.put(couple[0],couple[1]);
            pair.put(couple[1],couple[0]);
        }
        Map<Integer,Integer> love = new HashMap<>();//记录亲密度最高的
        for (int i=0;i<preferences.length;i++){
            love.put(i,preferences[i][0]);
        }
        /*
        不开心有两个条件
        1.有亲密度更高的人选
        2.所配对人于自己的亲密度胜过其配对的人
         */
        int ans=0;
        for(int i=0;i<pairs.length;i++){
              int[] p = pairs[i];
              if (!judge(p[0],p[1],preferences,love,pair)){
                  System.out.println(p[0]);
                  System.out.println(p[1]);
                  System.out.println();
                  ans++;
              }
            if (!judge(p[1],p[0],preferences,love,pair)){
                System.out.println(p[1]);
                System.out.println(p[0]);
                    System.out.println();
                ans++;
            }
        }
        return ans;
    }

    public int indexof(int[] p,int num){
        for (int i=0;i<p.length;i++){
            if (p[i]==num){
                return i;
            }
        }
        return -1;
    }
    public boolean judge(int x,int y,int[][] preferences,Map<Integer,Integer> love,Map<Integer,Integer> pair){
        int u = love.get(x);//x最爱的人
        if (y==u){
            return true;
        }
        int v = pair.get(u);//u的配对
        int[] feel = preferences[u];
        int index_X = indexof(feel,x);
        int index_V = indexof(feel,v);
        if (index_X<index_V){
            return false;
        }
        return true;
    }
}
