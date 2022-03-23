package 程序员面试金典;

import java.util.Arrays;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 14:39
 **/
public class topic1016 {
    public int smallestDifference(int[] a, int[] b) {
        long min = Long.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int indexA = 0,indexB = 0;
        while (indexA < a.length && indexB < b.length){
            long num = Math.abs(a[indexA] - b[indexB]);
            min = Math.min((int)num,min);
            if (a[indexA] > b[indexB]){
                indexB++;
            }
            else if (a[indexA] < b[indexB]){
                indexA++;
            }
            else if (a[indexA] == b[indexB]){
                return 0;
            }
        }
        return (int)min;
    }
}
