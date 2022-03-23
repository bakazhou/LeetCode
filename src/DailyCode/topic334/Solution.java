package DailyCode.topic334;

import java.util.LinkedList;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        //单调栈 维护一个单调递增的栈 栈中储存的是下标
        LinkedList<Integer> stack = new LinkedList<>();
        //形成单调递增栈
        for (int i=0;i<nums.length;i++){
            if (stack.isEmpty()){
                stack.add(i);
            }else {
                if (nums[i] > nums[stack.getLast()]){
                    stack.add(i);
                }else {
                    //当前元素小于等于栈顶元素
                    while (!stack.isEmpty() && nums[i] <= nums[stack.getLast()]){
                        stack.removeLast();
                    }
                    stack.add(i);
                }
            }
            if (stack.size()>=3){
                return true;
            }
        }
        //如果单调递增栈没找到
        //例如[20,100,10,12,5,13] 栈中元素为10 12 时遇到 5 后会全部弹出,因此在进行一次倒序遍历 找出一个单调递减栈
        stack = new LinkedList<>();
        for (int i=nums.length-1;i>=0;i--){
            if (stack.isEmpty()){
                stack.add(i);
            }else {
                if (nums[i] < nums[stack.getLast()]){
                    stack.add(i);
                }else {
                    //当前元素大于等于栈顶元素
                    while (!stack.isEmpty() && nums[i] >= nums[stack.getLast()]){
                        stack.removeLast();
                    }
                    stack.add(i);
                }
            }
            if (stack.size()>=3){
                return true;
            }
        }
        return false;
    }
}