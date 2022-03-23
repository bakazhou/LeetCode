package DailyCode.topic697;

public class answer {
    public int findShortestSubArray(int[] nums) {
        int left = 0, right = 0, ans = 0, n = nums.length,index=0;
        int [] first = new int[50000];
        int [] last = new int[50000];
        int [] flag = new int[50000];
        for (int i=0;i<50000;i++){
            first[i]=-1;
            last[i]=-1;
        }
        while (right < n) {
            if (last[nums[right]]==0){//第一次出现
                first[nums[right]]=right;
            }
            last[nums[right]]=right;
            flag[nums[right]]++;
            right++;
        }
        System.out.println(first[1]);
        System.out.println(last[1]);
        for (int i=0;i<50000;i++){
            if (flag[i]>index && flag[i]!=0){//找出出现次数最多的数
                index=flag[i];
                ans=last[i]-first[i];
            }
            else if (flag[i]==index && flag[i]!=0){
                index=flag[i];
                ans=Math.min(ans,last[i]-first[i]);
            }
        }
        return ans+1;
    }
}
