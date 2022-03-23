package DailyCode.topic480;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class answer {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> ans = new ArrayList<>();
        int right = 0,left = 0;
        List<Integer> sum = new ArrayList<>();
        for (int i=0;i<k-1;i++){
            right++;
            sum.add(nums[i]);
        }
        while (right<nums.length){
            sum.add(nums[right]);
            Collections.sort(sum);
            System.out.println(sum.toString());
            if (k%2!=0){
                ans.add((double)sum.get(k/2));
            }else {
                ans.add((double)((sum.get(k/2)+sum.get(k/2-1))/2));
            }
            right++;
            sum.remove(sum.indexOf(nums[left]));
            left++;
        }
        double[] p =new double[ans.size()];
        for (int i=0;i<ans.size();i++){
            p[i]=ans.get(i);
        }
        return p;
    }
}
