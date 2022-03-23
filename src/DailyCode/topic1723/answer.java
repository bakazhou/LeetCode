package DailyCode.topic1723;

import java.util.Arrays;

public class answer {
    public int minimumTimeRequired(int[] jobs, int k) {
        /*
        对jobs数组进行一个从大到小的排序
         */
        Arrays.sort(jobs);
        int low = 0, high = jobs.length - 1;
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }
        int max = 0,n=jobs.length,min=0,ans=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            max+=jobs[i];
        }
        while (min<=max){
            int mid = (max+min)/2;
            if (check(jobs,k,mid)){
                ans=mid;
                max=mid;
            }else {
                min=mid+1;
            }
        }
        return ans;
    }
    public boolean check(int[] jobs, int k, int limit) {
        int[] workforce = new int[k];//因为每次都需要新的数组来表示每个工人的工作时间
        return backtrack(limit,jobs,workforce,0);
    }

    public boolean backtrack(int work,int[] jobs,int workforce[],int index){
        if (index>=workforce.length) {
            return true;
        }
        int cur = jobs[index];
        for (int j = 0; j < workforce.length; ++j) {
            if (workforce[j] + cur <= work) {
                workforce[j] += cur;
                if (backtrack(work,jobs,workforce,index+1)) {
                    return true;
                }
                workforce[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到了上限
            // 这两种情况下我们无需尝试继续分配工作
            if (workforce[j] == 0 || workforce[j] + cur == work) {
                break;
            }
        }
        return false;
    }

}
