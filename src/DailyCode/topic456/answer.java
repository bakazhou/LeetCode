package DailyCode.topic456;

import java.util.LinkedList;

public class answer {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<n;i++){
            System.out.println(list);
            if (list.isEmpty()) list.add(nums[i]);
            else {
                if (list.getLast()<nums[i] && list.size()<=2){
                    list.add(nums[i]);
                }
                else if (nums[i]<list.getLast() && list.size()>=2){
                    return true;
                }
                else if (nums[i]<list.getLast() && list.size()<2){
                    while (!list.isEmpty() && list.getLast()>nums[i]){
                        list.removeLast();
                    }
                    list.add(nums[i]);
                }
            }
        }
        return false;
    }
}
