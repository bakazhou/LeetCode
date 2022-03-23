package DailyCode.topic1004;

public class answer {
    public int longestOnes(int[] A, int K) {
        int left=0,right=0,ans=0,n=A.length,sum=K;
        while (right<n && left<=right){
            if (A[right]==1){
                right++;
            }else {
                if (sum>0){
                    right++;
                    sum--;
                }else {
                    if (A[left]==0 && K!=0) {
                        sum++;
                    }else if (right==left && sum==0){
                        right++;
                    }
                    left++;
                }
            }
            ans=Math.max(ans,right-left);
        }
        return ans;
    }
}
