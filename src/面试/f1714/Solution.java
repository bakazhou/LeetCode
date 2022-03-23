package √Ê ‘.f1714;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

import java.util.Arrays;

public class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i=0;i<k;i++){
            ans[i] = arr[i];
        }
        return ans;
    }
}
