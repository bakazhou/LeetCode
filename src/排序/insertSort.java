package ����;

import java.util.Arrays;

public class insertSort {
    /*
    ��������
    ʱ�临�Ӷ�:O(N*N)
    �ռ临�Ӷ�Ϊ:O(1)
    ����˼��ӵڶ������ֿ�ʼ,��������ߵ����Ƚ�,�������ߵ���С,��ô����λ�ü���
     */
    public static void  swap(int i,int j,int[] nums){
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
    public static void sort(int[] nums){
        for (int i=1;i<nums.length;i++){
            for (int j=i;j>0;j--){
                if (nums[j]<nums[j-1]){
                    swap(j,j-1,nums);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1,3,80,70,44};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
