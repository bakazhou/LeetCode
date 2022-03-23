package DailyCode.topic978;

public class answer {
    public boolean judge(int left,int right){
        /*
        上升为true
        下降为false
         */
        if (right-left >0){
            return true;
        }else {
            return false;
        }
    }
    public int maxTurbulenceSize(int[] arr) {
        int left=0,right=0,ans=1,n=arr.length,sum=0;
        right++;
        if (n<=1){
            return 1;
        }
        boolean flag = judge(arr[left],arr[right]);
        while (right<n && left<=right){
            if (flag){
                //如果此时为上升段
                if (arr[right] > arr[right-1]){//满足上升条件
                    right++;
                    flag = !flag;//下次应该为下降
                }else {
                    if(arr[right] == arr[right-1]){//出现相等情况
                        right++;
                        left=right-1;
                        if(right<n-1){
                            flag=judge(arr[left],arr[right]);//判断首对为上升还是下降
                        }
                    }else{
                        left=right-1;
                        flag=judge(arr[left],arr[right]);
                    }
                }
            }else {
                if (arr[right] <arr[right-1]){
                    right++;
                    flag = !flag;
                }else {
                    if(arr[right] == arr[right-1]){
                        right++;
                        left=right-1;
                        if(right<n-1){
                            flag=judge(arr[left],arr[right]);
                        }
                    }else{
                        left=right-1;
                        flag=judge(arr[left],arr[right]);
                    }
                }
            }
            ans=Math.max(ans,right-left);

        }
        return ans;
    }
}
