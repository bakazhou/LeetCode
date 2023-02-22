package DailyCode.topic1326;

import java.util.TreeMap;

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] dis = new int[n + 1][2];
        for (int i = 0; i < ranges.length; i++) {
            int left = i - ranges[i];
            dis[i][0] = Math.max(left, 0);
            int right = i + ranges[i];
            dis[i][1] = Math.min(right, n);
        }
        //left -> right_max
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] di : dis) {
            map.put(di[0], Math.max(map.getOrDefault(di[0], Integer.MIN_VALUE), di[1]));
        }
        int left = map.firstKey(), right = map.get(map.firstKey()), res = 1;
        while (!map.isEmpty() && right != n) {
            int l = map.firstKey();
            int r = map.get(map.firstKey());
            System.out.println(l);
            System.out.println(r);
            if (l > right) {
                return -1;
            }
            while (!map.isEmpty() && map.firstKey() <= right) {
                r = Math.max(r, map.get(map.firstKey()));
                map.remove(map.firstKey());
            }
            res++;
            right = r;
        }
        return left == 0 && right == n ? res : -1;
    }
}