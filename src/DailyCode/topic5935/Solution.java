package DailyCode.topic5935;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��12�� 12:30
 **/
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        //��¼i��ǰ����������������
        int[] pre = new int[security.length];
        //��¼i��ǰ�������ݼ�������
        int[] after = new int[security.length];
        for (int i=1;i<security.length;i++){
            if (security[i] <= security[i-1]){
                pre[i] = pre[i-1] + 1;
            }else {
                pre[i] = 0;
            }
        }
        for (int i=security.length-2;i>=0;i--){
            if (security[i] <= security[i+1] ){
                after[i] = after[i+1] + 1;
            }else {
                after[i] = 0;
            }
        }
        for (int i=0;i<after.length;i++){
            if (pre[i] >= time && after[i] >= time){
                ans.add(i);
            }
        }
        return ans;
    }
}