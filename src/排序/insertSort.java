package 排序;

import java.util.Arrays;

public class insertSort {
    /*
    插入排序
    时间复杂度:O(N*N)
    空间复杂度为:O(1)
    主题思想从第二个数字开始,不断与左边的数比较,如果比左边的数小,那么交换位置即可
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
