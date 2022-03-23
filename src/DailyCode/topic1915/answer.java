package DailyCode.topic1915;

public class answer {
    public long wonderfulSubstrings(String word) {
        char[] chars = word.toCharArray();
        int left = 0,right = 0,n = chars.length;
        int[] calculateAhead = new int[26];//从前向后
        int[] calculateBefore = new int[26];//从后向前
        long ans = 0;
        for (int i=0;i<n;i++){
            calculateAhead[chars[i]-97]++;
            calculateBefore[chars[i]-97]++;
        }
        if (check(calculateAhead)){
            ans++;
        }
        for(int i=n-1;i>=0;i++){
            calculateBefore[chars[i]-97]--;
            if (check(calculateBefore)){
                ans++;
            }
        }
        return ans;
    }
    public boolean check(int[] calculate){
        int m = 0;
        for (int i =0;i<26;i++){
            if (calculate[i]%2!=0){
                m++;
            }
            if (m>1){
                return false;
            }
        }
        return true;
    }
}
