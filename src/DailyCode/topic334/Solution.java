package DailyCode.topic334;

import java.util.LinkedList;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        //����ջ ά��һ������������ջ ջ�д�������±�
        LinkedList<Integer> stack = new LinkedList<>();
        //�γɵ�������ջ
        for (int i=0;i<nums.length;i++){
            if (stack.isEmpty()){
                stack.add(i);
            }else {
                if (nums[i] > nums[stack.getLast()]){
                    stack.add(i);
                }else {
                    //��ǰԪ��С�ڵ���ջ��Ԫ��
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
        //�����������ջû�ҵ�
        //����[20,100,10,12,5,13] ջ��Ԫ��Ϊ10 12 ʱ���� 5 ���ȫ������,����ڽ���һ�ε������ �ҳ�һ�������ݼ�ջ
        stack = new LinkedList<>();
        for (int i=nums.length-1;i>=0;i--){
            if (stack.isEmpty()){
                stack.add(i);
            }else {
                if (nums[i] < nums[stack.getLast()]){
                    stack.add(i);
                }else {
                    //��ǰԪ�ش��ڵ���ջ��Ԫ��
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