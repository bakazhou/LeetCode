package DailyCode.topic154;

public class answer {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            //[4,5,6,7,0,1,3]
            // 0 1 2 3 4 5 6
            int mid = (left+right)/2;
            if (nums[mid]>nums[right]){
                left=mid;
            }else {
                right=mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(9/2);
    }
}
