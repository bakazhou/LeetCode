package DailyCode.topic33;

public class answer {
    public int search(int[] nums, int target) {
        return midSearch(nums,target);
    }
    public int midSearch(int[] nums, int target){
        /*
        将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
        此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
        */
        int high=nums.length-1,low=0,mid;
        //[4,0,1,2,3] [4,5,6,7,0,1,2] [4,5,6,7,0,1,2]
        while (low<=high){
            if (nums[low]==target) return low;
            if (nums[high]==target) return high;
            mid=(low+high)/2;
            if (nums[mid]>target){
                if (nums[mid]>nums[high]){
                    low=mid+1;
                }else {
                    high--;
                }
            }
            else if (nums[mid]==target){
                return mid;
            }
            else if (nums[mid]<target){
                low=mid+1;
            }
        }
        return -1;
    }
}
