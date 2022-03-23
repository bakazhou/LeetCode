package �������������ֵ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /*
    ��һ��arr���飬�涨�������ڴ�СΪw
    ���ع��ɵ�ÿ���������������ֵ���ɵļ���
    ��Ҫ˼�����ά��һ���Ӵ�С�Ķ���
    ��Ҫע��ľ��Ƕ��������ֵ�±�Ĺ�������,�����ڻ��������е����
     */
    public static List<Integer> maxList(int[] arr,int w){
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        //ά�ֶ�������������Ϊ�Ӵ�С�������д洢�������������±�
        for (int i=0;i<w;i++){
            int num = arr[i];
            if (queue.isEmpty()){
                queue.add(i);
            }else {
                while (!queue.isEmpty() && arr[queue.getLast()]<=num){
                    queue.removeLast();
                }
                queue.add(i);
            }
        }
        int low = 0,high = w;
        while (high<arr.length){
            ans.add(arr[queue.getFirst()]);
            if (low==queue.getFirst()){//�����е����ֵ��Ҫ���й��ڲ���,����ǰ���ֵ���±괦��low��
                queue.removeFirst();
            }
            low++;

            if (queue.isEmpty()){//����Ϊ��
                queue.add(high);
            }else {
                while (!queue.isEmpty() && arr[queue.getLast()]<=arr[high]){
                    queue.removeLast();
                }
                queue.add(high);
            }
            high++;
        }
        ans.add(arr[queue.getFirst()]);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {6,2,4,5,8,4,6,9};
        System.out.println(maxList(num,3));
    }
}
