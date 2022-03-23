package 排序;

import java.util.Arrays;

public class selectionSort {
    /*
    算法思想
    将每次找到的最小值不断向前移动
    第一次找到第一小的值,移动到0处
    以此类推
    算法时间复杂度O(N^2)
    算法空间复杂度O(1)
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
