package DailyCode;

import java.util.ArrayList;
import java.util.List;

public class topic4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length , m = nums2.length;
        List<Integer> list = new ArrayList<>(m+n);
        double ans = -1;
        int low1 = 0,low2 = 0;
        while(low1<n && low2<m){
            if (nums1[low1]<nums2[low2]){
                list.add(nums1[low1]);
                low1++;
            }
            else if (nums1[low1]==nums2[low2]){
                list.add(nums1[low1]);
                list.add(nums2[low2]);
                low1++;
                low2++;
            }
            else if (nums1[low1]>nums2[low2]){
                list.add(nums2[low2]);
                low2++;
            }
        }
        while (low1<n){
            list.add(nums1[low1]);
            low1++;
        }
        while (low2<m){
            list.add(nums2[low2]);
            low2++;
        }
        int index = (m+n)/2;
        return (m+n)%2==0?((double)(list.get(index))+(double)(list.get(index-1)))/2:(double)(list.get(index));
    }
}
