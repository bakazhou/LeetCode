package ����ջ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    //��һ������arr����֤û���ظ�ֵ,��Ҫ�ҳ�ÿ�����������ֵ���ұ�����ֵ,���û����Ϊnull
    //����˼����ά��һ���Ӵ�С�ĵ���ջ����ײ����
    public static void Demo(int[] arr){
        LinkedList<Integer> stack = new LinkedList<>();//��¼�����±�
        Map<Integer,Integer> left = new HashMap<>();//��¼�����±�
        Map<Integer,Integer> right = new HashMap<>();//��¼�����±�
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
                    }else {//���·���ջ��������ߵ����ֵ
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
            }else {//���·���ջ��������ߵ����ֵ
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
