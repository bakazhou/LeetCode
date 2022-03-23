package DailyCode.topic88;

import java.util.Arrays;

public class answer {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length;
        for (int i=0,j=0;i<length;i++,j++){
            nums1[i]=nums2[j];
        }
        Arrays.sort(nums1);
    }
}
