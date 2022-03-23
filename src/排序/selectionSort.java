package ����;

import java.util.Arrays;

public class selectionSort {
    /*
    �㷨˼��
    ��ÿ���ҵ�����Сֵ������ǰ�ƶ�
    ��һ���ҵ���һС��ֵ,�ƶ���0��
    �Դ�����
    �㷨ʱ�临�Ӷ�O(N^2)
    �㷨�ռ临�Ӷ�O(1)
     */
    public static void sort(int[] nums){
        if (nums==null || nums.length<2){
            return;
        }
        for (int i=0;i<nums.length;i++){
            int minIndex = i;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(i,minIndex,nums);
        }
    }
    public static void swap(int i,int j,int[] nums){
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1,3,80,70,44};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
