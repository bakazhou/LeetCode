package ����;

import java.util.Arrays;

public class bubbleSort {
    /*
    ð������
    ʱ�临�Ӷ�O(N*N)
    �ռ临�Ӷ�O(1)
    ��0��n��λ���ϣ�˭������˭������
    ��0��n-1��λ���ϣ�˭������˭������
     */
    public static void sort(int[] nums){
        if (nums==null || nums.length<2){
            return;
        }
        for (int i=nums.length-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if (nums[j]>nums[j+1]){
                    swap(j,j+1,nums);
                }
            }
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
