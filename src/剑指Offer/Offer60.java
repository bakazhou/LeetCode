package 剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class Offer60 {
    Set<String> set;
    int[] memo;
    public double[] dicesProbability(int n) {
        double[] ans;
        if (n==1){
            ans = new double[]{0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667};
            return ans;
        }
        ans = new double[n*6-(n-1)];
        memo = new int[n*6];
        double pro = 1;
        for (int i=0;i<n;i++){
            pro=pro*(double)1/(double)6;
        }
        for (int i=n;i<=n*6;i++){
            ans[i-n]=probability(n,0,i,0)*pro;
        }
        return ans;
    }
    public int probability(int n,int times,int goal,int cur){
        if (memo[cur]!=0){
            return memo[cur];
        }
        if (times==n){
            if (cur==goal){
                return 1;
            }
            return 0;
        }
        int pro = 0;
        for (int i=1;i<=6;i++){
            if (cur+i<=goal){
                pro = Math.max(pro,1+probability(n, times+1, goal, cur+i));
            }
        }
        memo[cur] = pro;
        return pro;
    }
}
