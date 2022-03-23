package DailyCode.topic2094;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ07ÈÕ 13:40
 **/
class Solution {
    Set<Integer> set;
    List<Integer> list;
    public int[] findEvenNumbers(int[] digits) {
        set = new HashSet<>();
        list = new ArrayList<>();
        boolean[] flag = new boolean[digits.length];
        dfs(digits,flag,"");
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void dfs(int[] digits,boolean[] flag,String cur){
        if (cur.length()==3){
            int num = Integer.parseInt(cur);
            if (!set.contains(num)){
                set.add(num);
                list.add(num);
            }
            return;
        }
        for (int i=0;i<digits.length;i++){
            if (flag[i]){
                continue;
            }
            if (cur.length() == 0){
                if (digits[i] == 0){
                    continue;
                }
            }
            else if (cur.length() == 2){
                if (digits[i]%2 != 0){
                    continue;
                }
            }
            flag[i] = true;
            dfs(digits, flag, cur+digits[i]);
            flag[i] = false;
        }
    }
}