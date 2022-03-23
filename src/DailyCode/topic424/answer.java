package DailyCode.topic424;

public class answer {
    /*
    使用双指针解决
    避免双层循环 时间复杂度O(N)
    代码算是写的简单好懂
    主要是像ABBB这样left第二次会从B开始 但是可变换次数还有剩余的情况下，可以向前进行变换
     */
    public int characterReplacement(String s, int k) {
        int ans=0,count=0,sum_k=k;
        int left=0,right=0;
        char flag;
        while(left<s.length() && right<s.length()){
            flag = s.charAt(left);
            if (s.charAt(right)==flag){
                count++;
                right++;
            }else {
                if (sum_k>0){
                    count++;
                    right++;
                    sum_k--;
                }else {
                    left++;
                    right=left;
                    sum_k=k;
                    count=0;
                }
            }
            if (right==s.length()){
                count+=sum_k;
                if (count>s.length()){
                    count=s.length();
                }
            }
            if (count>=ans){
                ans=count;
            }
        }
        return ans;
    }
}
