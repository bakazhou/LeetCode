package �����ݹ�.������Ѱ·����;

import java.util.Arrays;

public class Solution {
    //��������Ϊ·������Ϊn ��Ҫ�ߵ��±�Ϊtarget��,ÿ��ֻ�����������,��start����ʼ,��Ҫ��k�����������ߵ�target
    //���ж�����·��
    public int robotWay(int n,int target,int start,int k){
        return dfs(n, target, start, k);
    }

    //�����ݹ�
    public int dfs(int n,int target,int cur,int k){
        if (k==0){
            return cur==target?1:0;
        }
        if (cur == 1){//cur��1��ֻ��������
            return dfs(n,target,cur+1,k-1);
        }
        if (cur==n){//cur��n��ֻ��������
            return dfs(n,target,cur-1,k-1);
        }
        //�����������
        return dfs(n,target,cur+1,k-1)+dfs(n,target,cur-1,k-1);
    }
    /*
    Ȼ��ʵ����,�ڱ����ݹ�Ĺ��̵��оͻ�����ܶ����������ظ�����
    ��ô���Խ���Щ������������������������������ļ���Ϳ��Դӱ���ֱ��ȡ��
    robotWay(int n,int target,int start,int k)�����ڵ��ù�����,��Ϊn��target���ǹ̶���
    ���Կ��Կ���һ��������f(int start,int k)�ĺ���
    ��Ϊstart>=1 ��<=n
    ���Կ�����һ��int[n+1][k+1]�ı�����¼
     */
    public int memDfs(int n,int target,int cur,int k){
        int[][] mem = new int[n+1][k+1];
        for (int i=0;i<mem.length;i++){
            Arrays.fill(mem[i],-1);
        }
        return memeDfsMethod(n,target,cur,k,mem);
    }
    public int memeDfsMethod(int n,int target,int cur,int k,int[][] mem){
        if (mem[cur][k]!=-1){//�����м�¼
            return mem[cur][k];
        }
        //�����޼�¼
        if (k==0){
            //��¼��ǰ���
            mem[cur][k]  = cur==target?1:0;
            return mem[cur][k];
        }
        if (cur == 1){//cur��1��ֻ��������
            //��¼��ǰ���
            mem[cur][k] = dfs(n,target,cur+1,k-1);
            return mem[cur][k];
        }
        if (cur==n){//cur��n��ֻ��������
            //��¼��ǰ���
            mem[cur][k] = dfs(n,target,cur-1,k-1);
            return mem[cur][k];
        }
        //�����������
        mem[cur][k] = dfs(n,target,cur+1,k-1)+dfs(n,target,cur-1,k-1);
        return mem[cur][k];
    }
}
