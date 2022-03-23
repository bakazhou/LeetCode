package DailyCode.topic5936;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��12�� 12:30
 **/
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans = Integer.MIN_VALUE;
        //��¼ը����ź������������ը��
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //�жϵ�ǰը���Ƿ��Ѿ�������
        boolean[] flag = new boolean[bombs.length];
        for (int i=0;i<bombs.length;i++){
            Set<Integer> set = new HashSet<>();
            for (int j=0;j<bombs.length;j++){
                if (i!=j){
                    if (canBom(bombs,i,j)){
                        set.add(j);
                    }
                }
            }
            map.put(i,set);
        }
        //ѡ��������
        for (int i=0;i<bombs.length;i++){
            boolean[] clone = flag.clone();
            clone[i] = true;
            ans = Math.max(ans,dfs(clone,map,map.get(i)));
        }
        return ans;
    }
    public int dfs(boolean[] flag, Map<Integer, Set<Integer>> map, Set<Integer> set){
        int n = 1;
        for (int boom:set){
            if (!flag[boom]){
                flag[boom] = true;
                map.remove(boom);
                n += dfs(flag, map, map.get(boom));
            }
        }
        return n;
    }
    public boolean canBom(int[][] bombs, int i, int j){
        int[] b1 = bombs[i];
        int[] b2 = bombs[j];
        long x0 = b1[0], x1 = b2[0], y0 = b1[1], y1 = b2[1], r0 = b1[2];
        long len = (y1-y0)*(y1-y0) + (x1-x0)*(x1-x0);
        long r02 = r0 * r0;
        // ����������ƽ����(y1-y0)^2 + (x1-x0)^2 < �������뾶��ƽ����r0^2 ��ᱻ����
        if(len <= r02) return true;

        return false;

    }
}