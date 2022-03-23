package DailyCode.topic1482;

public class answer {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k>bloomDay.length) return -1;
        int day=0,max = Integer.MIN_VALUE,n = bloomDay.length;
        for (int i=0;i<n;i++){
            if (bloomDay[i]>max) max=bloomDay[i];
        }
        int low = 1,high = max;
        while (low<=high){
            int mid = (low+high)/2;
            if (judge(bloomDay,m,k,mid)){
                day=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return day;
    }
    public boolean judge(int[] bloomDay, int m, int k,int day){
        int make = 0;
        int left = 0,right = left+k;
        while (right<=bloomDay.length){
            int bloom = 0;
            for (int i=left;i<right;i++){
                if (bloomDay[i]-day>0){
                    left=i+1;
                    right=left+k;
                    break;
                }else bloom++;
            }
            if (bloom==k){
                left=right;
                right=left+k;
                make++;
            }
            if (make==m) return true;
        }
        return make==m?true:false;
    }
}
