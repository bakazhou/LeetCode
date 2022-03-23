package DailyCode.topic789;

public class Solution {
    /*
    实际上就是当前人能不能比阻碍者更快的到达终点
    也就是谁到终点更快
    到终点的最短距离实际上就是
    终点横坐标-起点横坐标+终点纵坐标-起点纵坐标
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = distance(0,0,target[0],target[1]);
        for (int i=0;i<ghosts.length;i++){
            int[] ghost = ghosts[i];
            int ghostDis = distance(ghost[0],ghost[1],target[0],target[1]);
            if (ghostDis<=dis){//ghost能捉到人
                return false;
            }
        }
        return true;
    }

    public int distance(int row,int col,int goalRow,int goalCol){
        return Math.abs(goalRow-row)+Math.abs(goalCol-col);
    }
}

