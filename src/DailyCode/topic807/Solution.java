package DailyCode.topic807;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��13�� 10:32
 **/
class Solution {
    /*
ÿһ��λ�õĽ�������ĸ��Ƕȿ������ܳ�����ߵ��Ǹ�����������һ�ŵĽ�����Ϊ { 3�� 0�� 8�� 7}��
��һ����ߵĽ�����ĸ߶���8����ôÿһ�еĽ����ﲻ�ܳ�����һ�ŵĽ������Ӧ�ģ�ÿһ��λ�õĽ����ﲻ�ܳ��������ڵ���һ�к���һ�У�
Ȼ��Ҫ�ó����н����������ӵ����ֵ���ܺ�
    */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //��
        List<Integer> row = new ArrayList<>();
        //��
        List<Integer> column = new ArrayList<>();
        for (int i=0;i<grid.length;i++){
            int max = Integer.MIN_VALUE;
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            row.add(max);
        }
        for (int i=0;i<grid[0].length;i++){
            int max = Integer.MIN_VALUE;
            for (int j=0;j<grid.length;j++){
                if (grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            column.add(max);
        }
        System.out.println(row);
        System.out.println(column);
        int ans = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int max = Math.min(row.get(i),column.get(j));
                if (grid[i][j] < max){
                    ans += max-grid[i][j];
                }
            }
        }
        return ans;
    }
}