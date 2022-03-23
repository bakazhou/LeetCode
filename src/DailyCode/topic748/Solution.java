package DailyCode.topic748;

import java.util.Arrays;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月10日 21:17
 **/
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseMem = new int[26];
        StringBuilder sb = new StringBuilder();
        String ans = "aaaaaaaaaaaaaaaaaa";
        for (int i=0;i<licensePlate.length();i++){
            //只要字母
            if (Character.isAlphabetic(licensePlate.charAt(i))){
                sb.append(licensePlate.charAt(i));
            }
        }
        licensePlate = sb.toString().toLowerCase();
        for (int i=0;i<licensePlate.length();i++){
            licenseMem[licensePlate.charAt(i)-97]++;
        }
        for (int i=0;i<words.length;i++){
            if (check(licenseMem,words[i])){
                if (words[i].length() < ans.length()){
                    ans = words[i];
                }
            }
        }
        return ans;
    }
    public boolean check(int[] mem,String str){
        int[] cur = new int[26];
        for (int i=0;i<str.length();i++){
            cur[str.charAt(i)-96]++;
        }
        for (int i=0;i<26;i++){
            if (mem[i] > cur[i]){
                System.out.println(str);
                System.out.println(Arrays.toString(mem));
                System.out.println(Arrays.toString(cur));
                System.out.println();
                return false;
            }
        }
        return true;
    }
}
