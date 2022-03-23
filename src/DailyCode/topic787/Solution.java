package DailyCode.topic787;

public class Solution {
        int ans;
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            /*
            n�ǳ�����
            flights -> {��ʼվ������վ����Ǯ}
            src��������
            dst�������
            kվ��ת
             */
            ans = Integer.MAX_VALUE;
            int[][] graph = new int[n][n];//���ͼ
            for (int i=0;i<flights.length;i++){
                int[] road = flights[i];
                graph[road[0]][road[1]] = road[2];
            }
            dfs(graph,src,dst,k+1,0,0);
            return ans==Integer.MAX_VALUE?-1:ans;
        }
        public void dfs(int[][] graph, int index, int dst, int k,int step,int price){
            if (step>k){
                return;
            }
            if (index==dst){
                ans = Math.min(price,ans);
                return;
            }
            int[] next = graph[index];
            for (int i=0;i<next.length;i++){
                if (next[i]!=0){//����ͨ��
                    //����+1,�۸���,����λ�ñ�Ϊi
                    dfs(graph,i,dst,k,step+1,price+next[i]);
                }
            }
        }
}
