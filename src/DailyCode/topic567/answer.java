package DailyCode.topic567;

import java.util.HashSet;
import java.util.Set;

public class answer {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        String flag = "";
        int n = s1.length(),right = 0,left = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0;i<n;i++){
            set.add(c1[i]);
        }
        for (int i = 0;i<n;i++){
            if(!set.contains(c2[i])){
                break;
            }else {
                right++;
            }
        }
        if (right==n){
            return true;
        }
        while (right<s2.length()-n){
            System.out.println(right);
            int m =0;
            while (m<n){
                if (set.contains(c2[right])){
                    right++;
                }else {
                    right++;
                    break;
                }
                m++;
            }
            if (m==n){
                return true;
            }
        }
        return false;
    }
    public boolean checkInclusion1(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int n = s1.length(),right = 0,left = 0;
        int[] i1 = new int[26];
        int[] i2 = new int[26];
        for (int i = 0;i<n;i++){
            i1[c1[i]-'a']++;
            i2[c2[i]='a']++;
            right++;
        }
        boolean ans = true;
        for (int i = 0;i<26;i++){
            if (i1[i]!=i2[i]){
                ans=false;
            }
        }
        if (ans){
            return true;
        }
        while (right<s2.length()){
            ans = true;
            i2[c2[right]-'a']++;
            i2[c2[left]-'a']--;
            for (int i = 0;i<26;i++){
                if (i1[i]!=i2[i]){
                    ans=false;
                    break;
                }
            }
            if (ans){
                return true;
            }
            right++;
            left++;
        }
        return false;
    }


    public boolean checkInclusion3(String s1, String s2) {
        int left=0,right=s1.length()-1,s2length=s2.length(),s1length=s1.length();
        int[] i1 = new int[26];
        int[] i2 = new int[26];
        if (s1length>s2length) return false;
        if (s1.equals(s2)) return true;
        String str = s2.substring(0,right+1);
        while (right<s2length){
            str = s2.substring(left,right+1);

            right++;
            left++;
        }
        return false;
    }
}
