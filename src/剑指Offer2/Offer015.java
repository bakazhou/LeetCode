package ½£Ö¸Offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] schar = new int[26];
        int[] pchar = new int[26];
        int n1 = s.length(),n2 = p.length();
        if(n2>n1){
            return list;
        }
        int low = 0,high = n2;
        for (int i=0;i<n2;i++){
            schar[s.charAt(i)-97]++;
            pchar[p.charAt(i)-97]++;
        }
        if (Arrays.equals(schar,pchar)){
            list.add(0);
        }
        while (high<n1){
            schar[s.charAt(low)-97]--;
            schar[s.charAt(high)-97]++;
            low++;
            high++;
            if (Arrays.equals(schar,pchar)){
                list.add(low);
            }
        }
        return list;
    }
}
