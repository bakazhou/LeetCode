package DailyCode.topic403;

public class answer {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<=1){
            return 0;
        }
        int[] tem = new int[nums.length];
        for (int i=1;i<nums.length;i++){
            tem[i]=nums[i]-nums[i-1];
        }
        int ans = 0,n=nums.length;
        for (int i=1;i<n;i++){
            int num = tem[i];
            for (int j=i+1;j<n;j++){
                if (tem[j]==num){
                    ans++;
                }else {
                    break;
                }
            }
        }
        return ans;
    }
}
