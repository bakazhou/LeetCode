package DailyCode.topic81;

public class answer {
    public boolean search(int[] nums, int target) {
        int begin = 0,end = nums.length-1,length = nums.length;
        if (nums[0]>target){//nums[0]已经大于target说明target在下一段上升序列中
            //找到下一段上升序列的开头
            for (int i=1;i<length;i++){
                if (nums[i]<nums[i-1]){
                    begin=i;
                    break;
                }
            }
        }
        else if (nums[0]==target){
            return true;
        }
        else if (nums[0]<target){
            //找到当前序列的结尾
            for (int i=1;i<length;i++){
                if (nums[i]<nums[i-1]){
                    end=i-1;
                    break;
                }
            }
        }
        return midSearch(nums,begin,end,target);
    }
    public boolean midSearch(int[] nums,int begin,int end,int target){
        while (begin<=end){
            int mid = (begin+end)/2;
            if (nums[mid]==target) return true;
            else if (nums[mid]>target){
                end=mid-1;
            }
            else if (nums[mid]<target){
                begin=mid+1;
            }
        }
        return false;
    }
}
