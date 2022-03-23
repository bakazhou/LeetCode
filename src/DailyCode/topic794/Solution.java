package DailyCode.topic794;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 10:53
 **/
class Point{
    int x;
    int y;
    Point(int n,int m){
        this.x = n;
        this.y = m;
    }
}
class Solution {
    boolean Flag = false;
    public boolean validTicTacToe(String[] board) {
        char[][] chessBoard = new char[3][3];
        char[][] curBoard = new char[3][3];
        ArrayList<Point> Xlist = new ArrayList<>();
        ArrayList<Point> Olist = new ArrayList<>();
        int X = 0,O = 0;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length();j++){
                chessBoard[i][j] = board[i].charAt(j);
                if (chessBoard[i][j] == 'X'){
                    X++;
                    Xlist.add(new Point(i,j));
                }
                else if (chessBoard[i][j] == 'O'){
                    O++;
                    Olist.add(new Point(i,j));
                }
            }
            //填充棋盘
            Arrays.fill(curBoard[i],' ');
        }
        if (O > X || Math.abs(O-X)>1){
            return false;
        }
        boolean[] Xvisited = new boolean[Xlist.size()];
        boolean[] Ovisited = new boolean[Olist.size()];
        dfs(chessBoard,curBoard,Xlist,Olist,'X',Xvisited,Ovisited);
        return Flag;
    }
    //cur棋盘有空格问题
    public void dfs(char[][] chessBoard, char[][] curBoard, ArrayList<Point> Xlist, ArrayList<Point> Olist, char cur,boolean[] Xvisited,boolean[] Ovisited){
        if (Flag){
            return;
        }
        if (judgeSucess(curBoard)){
            for (int i=0;i<Xvisited.length;i++){
                if (!Xvisited[i]){
                    return;
                }
            }
            for (int i=0;i<Ovisited.length;i++){
                if (!Ovisited[i]){
                    return;
                }
            }
            if (judgeSame(chessBoard,curBoard)){
                Flag = true;
            }
            return;
        }
        if (judgeSame(chessBoard,curBoard)){
            Flag = true;
            return;
        }
        if (cur == 'X'){
            for (int i=0;i<Xlist.size();i++){
                if (!Xvisited[i]){
                    Point first = Xlist.get(i);
                    Xvisited[i] = true;
                    char c = curBoard[first.x][first.y];
                    curBoard[first.x][first.y] = 'X';
                    dfs(chessBoard, curBoard, Xlist, Olist, 'O',Xvisited,Ovisited);
                    curBoard[first.x][first.y] = c;
                    Xvisited[i] = false;
                }
            }
        }
        else if (cur == 'O'){
            for (int i=0;i<Olist.size();i++){
                if (!Ovisited[i]){
                    Point first = Olist.get(i);
                    Ovisited[i] = true;
                    char c = curBoard[first.x][first.y];
                    curBoard[first.x][first.y] = 'O';
                    dfs(chessBoard, curBoard, Xlist, Olist, 'X',Xvisited,Ovisited);
                    curBoard[first.x][first.y] = c;
                    Ovisited[i] = false;
                }
            }
        }
    }
    //判断当前棋盘是否有一方已经胜利
    public boolean judgeSucess(char[][] curBoard){
        return (curBoard[0][0]!=' ' && curBoard[0][1]!=' ' && curBoard[0][2]!=' ' && curBoard[0][0]==curBoard[0][1] && curBoard[0][1]==curBoard[0][2]) ||
                (curBoard[1][0]!=' ' && curBoard[1][1]!=' ' && curBoard[1][2]!=' ' && curBoard[1][0]==curBoard[1][1] && curBoard[1][1]==curBoard[1][2]) ||
                (curBoard[2][0]!=' ' && curBoard[2][1]!=' ' && curBoard[2][2]!=' ' && curBoard[2][0]==curBoard[2][1] && curBoard[2][1]==curBoard[2][2]) ||
                (curBoard[0][0]!=' ' && curBoard[1][1]!=' ' && curBoard[2][2]!=' ' && curBoard[0][0]==curBoard[1][1] && curBoard[1][1]==curBoard[2][2]) ||
                (curBoard[0][2]!=' ' && curBoard[1][1]!=' ' && curBoard[2][0]!=' ' && curBoard[0][2]==curBoard[1][1] && curBoard[1][1]==curBoard[2][0]) ||
                (curBoard[0][0]!=' ' && curBoard[1][0]!=' ' && curBoard[2][0]!=' ' && curBoard[0][0]==curBoard[1][0] && curBoard[1][0]==curBoard[2][0]) ||
                (curBoard[0][1]!=' ' && curBoard[1][1]!=' ' && curBoard[2][1]!=' ' && curBoard[0][1]==curBoard[1][1] && curBoard[1][1]==curBoard[2][1]) ||
                (curBoard[0][2]!=' ' && curBoard[1][2]!=' ' && curBoard[2][2]!=' ' && curBoard[0][2]==curBoard[1][2] && curBoard[1][1]==curBoard[2][2]) ;
    }
    //判断当前棋盘是否相同
    public boolean judgeSame (char[][] chessBoard,char[][] curBoard){
        for (int i=0;i<3;i++){
            String s1 = new String(chessBoard[i]);
            String s2 = new String(curBoard[i]);
            if (!s1.equals(s2)){
                return false;
            }
        }
        return true;
    }
}