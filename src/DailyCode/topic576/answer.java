package DailyCode.topic576;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class answer {
    Set<String> road;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        road = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        int[] start = {startRow,startColumn};
        int[][] dis = {{0,1},{0,-1},{1,0},{-1,0}};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty() && maxMove!=0){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int[] location = queue.getFirst();
                queue.removeFirst();
                for (int j=0;j<dis.length;j++){
                    int[] dir = dis[j];
                    if (check(m,n,location[0]+dir[0],location[1]+dir[1])){
                        ans++;
                    }else {
                        queue.add(new int[]{location[0]+dir[0],location[1]+dir[1]});
                    }
                }
            }
        }
        return ans;
    }
    public boolean check(int m, int n,int row,int col){//返回有几种出界方式
        if (row<0 || col<0 || row>=m || col>=n){
            return true;
        }
        return false;
    }

    /*
    Set<String> road;
    int ans = 0;
    int[][] dis = {{0,1},{0,-1},{1,0},{-1,0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        road = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        return ans;
    }
    public boolean check(int m, int n,int row,int col){//返回是否出界
        if (row<0 || col<0 || row>=m || col>=n){
            return true;
        }
        return false;
    }
    public void dfs(int m, int n,int row,int col,StringBuilder sb,int maxMove){
        if (maxMove<0 || road.contains(sb.toString())){
            return;
        }
        if (check(m, n, row, col)){
            ans++;
            return;
        }
        //上下左右四个方向
        for (int i=0;i<dis.length;i++){
            int[] dir = dis[i];

        }
    }
     */
}
