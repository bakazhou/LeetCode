package DailyCode.topic1894;

public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int index = 0,n = chalk.length;
        for (int i=0;i<=n;i++){
            if (i==n){
                i=0;
            }
            k=k-chalk[i];
            if (k<0){
                return i;
            }
        }
        return -1;
    }
}
