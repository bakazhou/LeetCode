package ½£Ö¸Offer2;

import java.util.HashSet;
import java.util.Set;

public class Offer016 {
    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE,n = s.length();
        Set<Character> set = new HashSet<>();
        int low = 0,high = 0;
        while (high<n){
            System.out.println(set);
            if (!set.contains(s.charAt(high))){
                set.add(s.charAt(high));
            }else {
                while(set.contains(s.charAt(high))){
                    set.remove(s.charAt(low));
                    low++;
                }
            }
            high++;
            ans = Math.max(ans,set.size());
        }
        return ans;
    }
}
