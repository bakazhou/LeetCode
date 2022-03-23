package 剑指Offer;

import java.util.LinkedList;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int ans = 1;
        char[] chars = s.toCharArray();
        int left=0,right=0;
        LinkedList<Character> queue = new LinkedList<>();
        while (right<chars.length){
            if (!queue.contains(chars[right])){
                queue.add(chars[right]);
                right++;
            }else {
                while (queue.contains(chars[right])){
                    queue.removeFirst();
                }
            }
            ans=Math.max(ans,queue.size());
        }
        return ans;
    }


    public boolean judge(int[] caculate){
        for (int i=0;i<26;i++){
            if (caculate[i]>1){
                return false;
            }
        }
        return true;
    }
}
