package DailyCode.topic51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class answer {
    List<List<String>> ans;
    String[][] map;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        map = new String[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                map[i][j]=".";
            }
        }
        LinkedList<String> road = new LinkedList<>();
        backtrack(0,n,road);
        return ans;
    }
    //进行搜索和回溯
    public void backtrack(int row, int n, LinkedList<String> road){
        //1.终止条件
        if (road.size()==n){
            ans.add(new LinkedList<>(road));
            return;
        }
        for(int i=0;i<n;i++){
            //2.尝试放置
            if (judge(row,i,n)) map[row][i]="Q";
            else continue;
            String string = "";
            for (int j=0;j<n;j++){
                string+=map[row][j];
            }
            road.add(string);
            //3.继续递归
            backtrack(row+1, n, road);
            //4.状态恢复
            map[row][i]=".";
            road.removeLast();
        }
    }
    //判断皇后是否被攻击
    public boolean judge(int x,int y,int n){
        for (int i=x,j=0;j<n;j++){
            if (map[i][j].equals("Q")) return false;
        }
        for (int i=y,j=0;j<n;j++){
            if (map[j][i].equals("Q")) return false;
        }
        for (int i=x,j=y;i<n&&j<n;i++,j++){//右下斜
            if (map[i][j].equals("Q")) return false;
        }
        for (int i=x,j=y;i>=0&&j<n;i--,j++){//右上斜
            if (map[i][j].equals("Q")) return false;
        }
        for (int i=x,j=y;i<n&&j>=0;i++,j--){//左下斜
            if (map[i][j].equals("Q")) return false;
        }
        for (int i=x,j=y;i>=0&&j>=0;i--,j--){//左上斜
            if (map[i][j].equals("Q")) return false;
        }
        return true;
    }
}
