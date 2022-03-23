package DailyCode.topic704;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low=0,high=n;
        while (low<high){
            int mid = (low+high)/2;
            if (nums[mid]==target){
                return mid;
            }
            else if (nums[mid]<target){
                low = mid+1;
            }
            else if (nums[mid]>target){
                high = low-1;
            }
        }
        return -1;
    }
}
