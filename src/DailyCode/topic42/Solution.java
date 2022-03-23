package DailyCode.topic42;

import java.util.LinkedList;

class Solution {
    public int trap(int[] height) {
        if (height.length<3){
            return 0;
        }
        int ans = 0;
        //记录下标
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i=0;i<height.length;i++){
            if (stack.isEmpty()){
                stack.add(i);
            }else {
                //保持单调递减的栈
                if (height[i]<=height[stack.getLast()]){
                    stack.add(i);
                }else {
                    while (!stack.isEmpty() && height[i]>height[stack.getLast()]){
                        //当前栈顶的高度
                        int h = height[stack.getLast()];
                        stack.removeLast();
                        if (stack.isEmpty()){
                            break;
                        }
                        //取两者高度差的较小值
                        int n = Math.min(height[i]-h,height[stack.getLast()]-h);
                        //两点的下标距离
                        int index = i - stack.getLast()-1;
                        ans += n*index;
                    }
                    stack.add(i);
                }
            }
        }
        return ans;
    }
}