package 单调栈;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    //给一个数组arr，保证没有重复值,需要找出每个数左边最大的值和右边最大的值,如果没有则为null
    //中心思想是维持一个从大到小的单调栈，最底部最大
    public static void Demo(int[] arr){
        LinkedList<Integer> stack = new LinkedList<>();//记录的是下标
        Map<Integer,Integer> left = new HashMap<>();//记录的是下标
        Map<Integer,Integer> right = new HashMap<>();//记录的是下标
        for (int i=0;i<arr.length;i++){
            if (stack.isEmpty()){
                stack.add(i);
            }else {
                while (!stack.isEmpty() && arr[stack.getLast()]<arr[i]){
                    int index = stack.getLast();
                    int num = arr[index];
                    stack.removeLast();
                    if (stack.isEmpty()){
                        left.put(index,null);
                    }else {//其下方的栈就是其左边的最大值
                        left.put(index,stack.getLast());
                    }
                    right.put(index,i);
                }
                stack.add(i);
            }
        }
        while (!stack.isEmpty()){
            int index = stack.getLast();
            stack.removeLast();
            if (stack.isEmpty()){
                left.put(index,null);
            }else {//其下方的栈就是其左边的最大值
                left.put(index,stack.getLast());
            }
            right.put(index,null);
        }
        System.out.println(left);
        System.out.println(right);
    }

    public static void main(String[] args) {
        int[] num = {5,4,3,6,1,2,0};
        Demo(num);
    }
}
