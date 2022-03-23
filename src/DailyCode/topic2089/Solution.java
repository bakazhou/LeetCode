package DailyCode.topic2089;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��08�� 18:10
 **/
public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i] == target){
                list.add(i);
            }
        }
        return list;
    }

}
