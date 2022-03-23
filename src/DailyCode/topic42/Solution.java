package DailyCode.topic42;

import java.util.LinkedList;

class Solution {
    public int trap(int[] height) {
        if (height.length<3){
            return 0;
        }
        int ans = 0;
        //��¼�±�
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i=0;i<height.length;i++){
            if (stack.isEmpty()){
                stack.add(i);
            }else {
                //���ֵ����ݼ���ջ
                if (height[i]<=height[stack.getLast()]){
                    stack.add(i);
                }else {
                    while (!stack.isEmpty() && height[i]>height[stack.getLast()]){
                        //��ǰջ���ĸ߶�
                        int h = height[stack.getLast()];
                        stack.removeLast();
                        if (stack.isEmpty()){
                            break;
                        }
                        //ȡ���߸߶Ȳ�Ľ�Сֵ
                        int n = Math.min(height[i]-h,height[stack.getLast()]-h);
                        //������±����
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