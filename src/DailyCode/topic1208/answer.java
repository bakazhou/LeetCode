package DailyCode.topic1208;

public class answer {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans=0;
        int sum = maxCost,n=0;
        int left = 0,right = 0;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        while (right<s.length() && left<s.length()){
            int m=Math.abs(sc[right]-tc[right]);
            if (m <= sum){
                n++;
                sum-=m;
                right++;
                ans=Math.max(ans,n);
            }else {
                n=0;
                sum=sum-Math.abs(sc[left]-tc[left]);
                left++;
            }

        }
        return ans;
    }
}
