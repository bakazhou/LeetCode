package 程序员面试金典;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月13日 14:24
 **/
public class topic0801 {
    int MOD = 1000000007;
    int[][] mem;
    //币值为25分、10分、5分和1分
    public int waysToChange(int n) {
        int[] money = new int[]{1,5,10,25};
        mem = new int[n+1][money.length+1];
        return dfs(n,money,0);
    }
    public int dfs(int cur,int[] money,int index){
        if (cur >= 0 && mem[index][cur] != 0){
            return mem[cur][index];
        }
        if (cur == 0){
            return 1;
        }
        if (cur < 0){
            return 0;
        }
        int m = 0;
        for (int i=index;i<money.length;i++){
            if (cur - money[i] >= 0){
                m += dfs(cur-money[i],money,i);
            }
        }
        mem[cur][index] = m;
        return m % MOD;
    }
}
