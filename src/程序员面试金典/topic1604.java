package 程序员面试金典;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 14:04
 **/
public class topic1604 {
    public String tictactoe(String[] board) {
        char[][] curBoard = new char[board.length][board[0].length()];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length();j++){
                curBoard[i][j] = board[i].charAt(j);
            }
        }
        return judgeSucess(curBoard);
    }
    //判断当前棋盘是否有一方已经胜利
    public String judgeSucess(char[][] curBoard){
        boolean space = false;
        //检查每行
        for (int i=0;i<curBoard.length;i++){
            //行头字母
            char c = curBoard[i][0];
            boolean flag = true;
            for (int j=0;j<curBoard[0].length;j++){
                if (curBoard[i][j] == ' '){
                    space = true;
                    flag = false;
                    break;
                }
                if (curBoard[i][j] != c){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return c+"";
            }
        }
        //检查每列
        for (int j=0;j<curBoard[0].length;j++){
            char c = curBoard[0][j];
            boolean flag = true;
            for (int i=0;i<curBoard.length;i++){
                if (curBoard[i][j] != c || c == ' '){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return c+"";
            }
        }
        //检查对角线
        char c = curBoard[0][0];
        if (c != ' '){
            boolean flag = true;
            for (int i=0;i<curBoard.length;i++){
                if (curBoard[i][i] != c){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return c+"";
            }
        }
        c = curBoard[0][curBoard[0].length-1];
        if (c != ' '){
            boolean flag = true;
            for (int i=0,j=curBoard[0].length-1;i<curBoard.length;i++,j--){
                if (curBoard[i][j] != c){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return c+"";
            }
        }
        //说明无人获胜且有空格
        if (space){
            return "Pending";
        }
        return "Draw";
    }
}
