package ��ָOffer2;

import java.util.LinkedList;

public class Offer037 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = asteroids.length;
        for (int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.add(asteroids[i]);
            }else {
                boolean as = judge(asteroids[i]);//�ж��µ�С����������������
                boolean stackAs = judge(stack.getLast());//�ж�stack�е�С����������������
                boolean flag = true;//�ж�С�����Ƿ񻹴���
                if (as == stackAs || as==true && stackAs==false){//ջ��С���Ƿ�������,��С��������
                    stack.add(asteroids[i]);
                }else if (as==false && stackAs==true){
                    while (!stack.isEmpty() && judge(stack.getLast())!=as){//ֱ��stack�ж���ͬһ�����С����
                        if (Math.abs(stack.getLast())-Math.abs(asteroids[i])>0){//�µ�С���Ǳ�ײ��
                            flag=false;
                            break;
                        }
                        else if (Math.abs(stack.getLast())-Math.abs(asteroids[i])==0){//����С���Ƕ�ײ��
                            stack.removeLast();
                            flag=false;
                            break;
                        }
                        else if (Math.abs(stack.getLast())-Math.abs(asteroids[i])<0){//�µ�С���Ǳ�ջ��С���Ǵ�
                            while(!stack.isEmpty() && judge(stack.getLast())!=as && Math.abs(stack.getLast())-Math.abs(asteroids[i])<0){//��С���Ǵݻ�ջ��С����,ֱ������ͬ����С���ǻ����������С����
                                stack.removeLast();
                            }
                        }
                    }
                    if (flag){//С���ǻ���
                        stack.add(asteroids[i]);
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            ans[index] = stack.getFirst();
            stack.removeFirst();
            index++;
        }
        return ans;
    }
    public boolean judge(int num){
        if (num>=0){
            return true;
        }
        return false;
    }
}
