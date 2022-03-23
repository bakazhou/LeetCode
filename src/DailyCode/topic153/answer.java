package DailyCode.topic153;

public class answer {
    public int findMin(int[] nums) {
        /*
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];

         */
        int right = nums.length-1,left= 0,ans = 0;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]>nums[right]){

            }else if (nums[mid]<nums[right]){

            }
        }
        return ans;
    }
}
