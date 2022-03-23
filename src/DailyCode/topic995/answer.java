package DailyCode.topic995;

public class answer {
    public int minKBitFlips(int[] A, int K) {
        int ans=0,right=0,left=0,n=A.length;
        while (left<n){
            while (left<n && A[left]!=0){
                left++;
            }
            if (left+K<=n){
                for (int i=left;i<left+K;i++){
                    if (A[i]==0){
                        A[i]=1;
                    }else {
                        A[i]=0;
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}
