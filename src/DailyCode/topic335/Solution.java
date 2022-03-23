package DailyCode.topic335;

import java.util.*;

class Solution {
    public boolean isSelfCrossing(int[] distance) {
        /*
        先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米
        即上 左 下 右 四方向
         */
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int[][] dir = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int x=0,y=0;
        HashSet<Integer> set = new HashSet<>();
        set.add(y);
        map.put(x,set);
        for (int i=0;i<distance.length;i++){
            for (int j=0;j<distance[i];j++){
                x += dir[i][0];
                y += dir[i][1];
                if (!map.containsKey(x)){
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(y);
                    map.put(x,hashSet);
                }else {
                    HashSet<Integer> hashSet = map.get(x);
                    if (hashSet.contains(y)){
                        return true;
                    }
                    hashSet.add(y);
                }
            }
        }
        return false;
    }


    public boolean isSelfCrossing1(int[] distance) {
        for(int i=3, l=distance.length; i<l; i++) {
            // Case 1: current line crosses the line 3 steps ahead of it
            if(distance[i]>=distance[i-2] && distance[i-1]<=distance[i-3]) {
                return true;
            }
                // Case 2: current line crosses the line 4 steps ahead of it
            else if(i>=4 && distance[i-1]==distance[i-3] && distance[i]+distance[i-4]>=distance[i-2]) {
                return true;
            }
                // Case 3: current line crosses the line 6 steps ahead of it
            else if(i>=5 && distance[i-2]>=distance[i-4] && distance[i]+distance[i-4]>=distance[i-2] && distance[i-1]<=distance[i-3] && distance[i-1]+distance[i-5]>=distance[i-3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 4;
        System.out.println(a/b);
    }
}