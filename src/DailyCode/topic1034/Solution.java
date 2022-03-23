package DailyCode.topic1034;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月07日 9:13
 **/
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int curColor = grid[row][col];
        LinkedList<int[]> queue = new LinkedList<>();
        List<int[]> boader = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int[] cur = new int[]{row,col};
        queue.add(cur);
        set.add(row+"+"+col);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i=0;i<n;i++){
                int[] first = queue.getFirst();
                queue.removeFirst();
                int curRow = first[0];
                int curCol = first[1];
                if (curRow == 0 || curRow == grid.length-1 || curCol == 0 || curCol == grid[0].length-1){
                    grid[curRow][curCol] = color;
                }
                //检查上下左右
                if (curRow-1>=0 && !set.contains((curRow-1)+"+"+curCol) && grid[curRow-1][curCol]==curColor){
                    queue.add(new int[]{curRow-1,curCol});
                    set.add((curRow-1)+"+"+curCol);
                    if (curRow == row && curCol == col){
                        boader.add(new int[]{curRow-1,curCol});
                    }
                }
                if (curRow+1<grid.length && !set.contains((curRow+1)+"+"+curCol) && grid[curRow+1][curCol]==curColor){
                    queue.add(new int[]{curRow+1,curCol});
                    set.add((curRow+1)+"+"+curCol);
                    if (curRow == row && curCol == col){
                        boader.add(new int[]{curRow+1,curCol});
                    }
                }
                if (curCol-1>=0 && !set.contains(curRow+"+"+(curCol-1)) && grid[curRow][curCol-1]==curColor){
                    queue.add(new int[]{curRow,curCol-1});
                    set.add(curRow+"+"+(curCol-1));
                    if (curRow == row && curCol == col){
                        boader.add(new int[]{curRow,curCol-1});
                    }
                }
                if (curCol+1<grid[0].length && !set.contains(curRow+"+"+(curCol+1)) && grid[curRow][curCol+1]==curColor){
                    queue.add(new int[]{curRow,curCol+1});
                    set.add(curRow+"+"+(curCol+1));
                    if (curRow == row && curCol == col){
                        boader.add(new int[]{curRow,curCol+1});
                    }
                }
            }
        }
        for (int[] index : boader){
            grid[index[0]][index[1]] = color;
        }
        return grid;
    }
}