package DailyCode.topic789;

public class Solution {
    /*
    ʵ���Ͼ��ǵ�ǰ���ܲ��ܱ��谭�߸���ĵ����յ�
    Ҳ����˭���յ����
    ���յ����̾���ʵ���Ͼ���
    �յ������-��������+�յ�������-���������
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = distance(0,0,target[0],target[1]);
        for (int i=0;i<ghosts.length;i++){
            int[] ghost = ghosts[i];
            int ghostDis = distance(ghost[0],ghost[1],target[0],target[1]);
            if (ghostDis<=dis){//ghost��׽����
                return false;
            }
        }
        return true;
    }

    public int distance(int row,int col,int goalRow,int goalCol){
        return Math.abs(goalRow-row)+Math.abs(goalCol-col);
    }
}

