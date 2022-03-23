package DailyCode.topic786;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ01ÈÕ 10:18
 **/
class Solution {
    /**
     * @author bakazhou
     * @description
     * @date 2021/12/1 10:18
     * @param arr
     * @param k
     * @return int[]
     **/
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int times = 0;
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<arr.length-1;i++){
            for (int j=arr.length-1;j>i;j--){
                int[] ans = new int[2];
                ans[0] = arr[i];
                ans[1] = arr[j];
                list.add(ans);
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ((double)o1[0]/(double)o1[1] > (double)o2[0]/(double)o2[1]){
                    return 1;
                }
                return -1;
            }
        });
        for (int i=0;i<list.size();i++){
            System.out.println(Arrays.toString(list.get(i)));
        }
        return list.get(k-1);
    }
}