package 程序员面试金典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月13日 14:07
 **/
public class topic0108 {
    public void setZeroes(int[][] matrix) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for (int i=0;i<x.size();i++){
            beZero(x.get(i),y.get(i),matrix);
        }
    }
    public void beZero(int x,int y,int[][] matrix){
        //用于替换的行
        int[] temRow = new int[matrix[0].length];
        matrix[x] = temRow;
        for (int i=0;i<matrix.length;i++){
            matrix[i][y] = 0;
        }
    }
}
