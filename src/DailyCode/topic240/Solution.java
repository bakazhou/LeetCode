package DailyCode.topic240;

import java.util.Scanner;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++){
            //已经不可能找到,直接返回
            //target小于当前行最小值
            if (matrix[i][0]>target){
                return false;
            }
            //target>当前行最大值
            if (matrix[i][matrix[i].length-1]<target){
                continue;
            }
            if (midSearch(matrix[i],target)){
                return true;
            }
        }
        return false;
    }
    public boolean midSearch(int[] matrix,int target){
        int low = 0,high = matrix.length-1;
        if (matrix[low]==target || matrix[high]==target){
            return true;
        }
        while (low<=high){
            int mid = (low+high)/2;
            if (matrix[mid]==target){
                return true;
            }
            else if (matrix[mid]>target){
                high = mid-1;
            }
            else if (matrix[mid]<target){
                low = mid+1;
            }
        }
        return false;
    }
}