package �����ݹ�.Ӳ������;

public class Solution {
    //moneyΪһ��Ӳ�����,targetΪ��Ҫ�ճ�����Ǯ,moneyCount�����ж����ִշ�,ÿ��Ӳ�ҵ����������޵�,�ҳ�ʹ����Ǯ���ٵĴշ�
    public int moneyDfsCount(int[] money,int target){
        return ans;
    }
    public int ans = Integer.MAX_VALUE;
    //�����ݹ�
    //cur�ǵ�ǰ��Ҫ�ճ���Ǯ
    public void dfs(int[] money,int cur,int step){
        if (cur == 0){
            ans = Math.min(step,ans);
            return;
        }
        if (cur < 0){//�޷��ճ�
            return;
        }
        for (int i=0;i<money.length;i++){
            dfs(money, cur-money[i], step+1);
        }
    }

}
