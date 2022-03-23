package DailyCode.topic485;

public class answer {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0,right=0,n=nums.length,ans=0;
        while (right<n){
            if (right==1){
                right++;
                if (right-left+1>ans){
                    ans=right-left+1;
                }
            }else {
                right++;
                left=right;
            }
        }
        return ans;
    }
}
