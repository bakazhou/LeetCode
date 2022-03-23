package DailyCode.topic787;

public class Solution {
        int ans;
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            /*
            n是城市数
            flights -> {起始站，到达站，价钱}
            src出发城市
            dst到达城市
            k站中转
             */
            ans = Integer.MAX_VALUE;
            int[][] graph = new int[n][n];//造出图
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
                if (next[i]!=0){//可以通行
                    //步数+1,价格变更,所在位置变为i
                    dfs(graph,i,dst,k,step+1,price+next[i]);
                }
            }
        }
}
