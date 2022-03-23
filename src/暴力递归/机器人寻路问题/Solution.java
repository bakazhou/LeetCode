package 暴力递归.机器人寻路问题;

import java.util.Arrays;

public class Solution {
    //参数含义为路径长度为n 需要走到下标为target处,每次只能向左或向右,从start处开始,需要在k步的限制内走到target
    //求有多少种路径
    public int robotWay(int n,int target,int start,int k){
        return dfs(n, target, start, k);
    }

    //暴力递归
    public int dfs(int n,int target,int cur,int k){
        if (k==0){
            return cur==target?1:0;
        }
        if (cur == 1){//cur在1处只能向右走
            return dfs(n,target,cur+1,k-1);
        }
        if (cur==n){//cur在n处只能向左走
            return dfs(n,target,cur-1,k-1);
        }
        //左右两种情况
        return dfs(n,target,cur+1,k-1)+dfs(n,target,cur-1,k-1);
    }
    /*
    然而实际上,在暴力递归的过程当中就会产生很多的冗余计算重复计算
    那么可以将这些计算结果保存下来，如果再遇到这样的计算就可以从表中直接取出
    robotWay(int n,int target,int start,int k)函数在调用过程中,因为n和target都是固定的
    所以可以看作一个类似于f(int start,int k)的函数
    因为start>=1 且<=n
    所以可以用一个int[n+1][k+1]的表来记录
     */
    public int memDfs(int n,int target,int cur,int k){
        int[][] mem = new int[n+1][k+1];
        for (int i=0;i<mem.length;i++){
            Arrays.fill(mem[i],-1);
        }
        return memeDfsMethod(n,target,cur,k,mem);
    }
    public int memeDfsMethod(int n,int target,int cur,int k,int[][] mem){
        if (mem[cur][k]!=-1){//表中有记录
            return mem[cur][k];
        }
        //表中无记录
        if (k==0){
            //记录当前情况
            mem[cur][k]  = cur==target?1:0;
            return mem[cur][k];
        }
        if (cur == 1){//cur在1处只能向右走
            //记录当前情况
            mem[cur][k] = dfs(n,target,cur+1,k-1);
            return mem[cur][k];
        }
        if (cur==n){//cur在n处只能向左走
            //记录当前情况
            mem[cur][k] = dfs(n,target,cur-1,k-1);
            return mem[cur][k];
        }
        //左右两种情况
        mem[cur][k] = dfs(n,target,cur+1,k-1)+dfs(n,target,cur-1,k-1);
        return mem[cur][k];
    }
}
