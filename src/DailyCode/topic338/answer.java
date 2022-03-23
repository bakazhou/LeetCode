package DailyCode.topic338;

import java.math.BigInteger;

public class answer {
    public int count(int num){
        int tem = 0;
        String ans;
        BigInteger n = new BigInteger(String.valueOf(num));
        ans= n.toString(2);
        char[] chars = ans.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if (chars[i]=='1'){
                tem++;
            }
        }
        return tem;
    }
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for (int i=0;i<=num;i++){
            ans[i]=count(i);
        }
        return ans;
    }
}
