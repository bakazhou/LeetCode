package DailyCode.topic239;

import java.util.*;

public class answer {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length,right = k,left=0;
        List<Integer> temp = new ArrayList<>();
        if (n<k){
            return new int[]{};
        }
        int[] ans = new int[n-k+1];
        for (int i=0;i<k;i++){
            temp.add(nums[i]);
        }
        while (right<n){
            Collections.sort(temp);
            ans[left]=temp.get(k-1);
            temp.remove(temp.indexOf(nums[left]));
            temp.add(nums[right]);
            left++;
            right++;
        }
        Collections.sort(temp);
        ans[left]=temp.get(k-1);
        return ans;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length,right = k,left=0;
        LinkedList<Integer> temp = new LinkedList<>();//使用双端队列
        if (k==1){
            return nums;
        }
        int[] ans = new int[n-k+1];
        temp.offer(nums[0]);
        for (int i=1;i<k;i++){
            while (!temp.isEmpty() && nums[i]>temp.getLast()){
                temp.removeLast();
            }
            temp.offer(nums[i]);
        }
        while (right<n){
            ans[left]=temp.getFirst();
            if (temp.getFirst()==nums[left]){
                temp.removeFirst();
            }
            while (!temp.isEmpty() && nums[right]>temp.getLast()){
                temp.removeLast();
            }
            temp.offer(nums[right]);
            right++;
            left++;
        }
        ans[left]=temp.getFirst();
        return ans;
    }
}
