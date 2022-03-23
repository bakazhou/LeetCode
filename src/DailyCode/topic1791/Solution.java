package DailyCode.topic1791;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê02ÔÂ18ÈÕ 22:10
 **/
class Solution {
    public int findCenter(int[][] edges) {
        int[] point = new int[edges.length+1];
        for (int i=0;i<edges.length;i++){
            point[edges[i][0]-1]++;
            point[edges[i][1]-1]++;
            if (point[i] == edges.length-1){
                return i+1;
            }
        }
        return 1;
    }
}