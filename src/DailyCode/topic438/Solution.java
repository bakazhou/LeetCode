package DailyCode.topic438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left=0,right=p.length()-1,slength=s.length(),plength=p.length();
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        List<Integer> ans = new ArrayList<>();
        if (plength>slength) return ans;
        int[] i1 = new int[26];
        int[] i2 = new int[26];

        for (int i=0;i<plength;i++){
            i2[p1[i]-97]++;
        }
        for (int i=0;i<plength-1;i++){
            i1[s1[i]-97]++;
        }
        while (right<slength){
            i1[s1[right]-97]++;
            boolean flag = true;
            for (int i=0;i<26;i++){
                if (i1[i]!=i2[i]){
                    flag=false;
                    break;
                }
            }
            if (flag){
                String str = s.substring(left,right+1);
                if (!str.equals(p)){
                    System.out.println(str);
                    ans.add(left);
                }
            }
            i1[s1[left]-97]--;
            right++;
            left++;
        }
        return ans;
    }
}
