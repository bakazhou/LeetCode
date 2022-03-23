package DailyCode.topic1047;

import java.util.*;

public class answer {
    public String removeDuplicates1(String S) {
        String ans = "";
        char[] chars = S.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        int right = 0,n = S.length();
        while (right<n){
            if (list.isEmpty()){
                list.offerLast(chars[right]);
                ans+=chars[right];
            }else {
                if (S.charAt(right) == list.getLast()) {
                    list.removeLast();
                    ans=ans.substring(0,ans.length()-1);
                } else {
                    list.offerLast(chars[right]);
                    ans+=chars[right];
                }
            }
            right++;
        }
        return ans;
    }
    public String removeDuplicates(String S) {
        int left = 0,right = 1,n = S.length();
        String ans = S;
        while (right<n){
            if (ans.charAt(left)==ans.charAt(right)){
                String temp1 = ans.substring(0,left);
                String temp2 = ans.substring(right+1,n);
                ans = temp1+temp2;
                right=1;
                left=0;
                n=ans.length();
            }else {
                right++;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "123456";
        System.out.println(str.substring(0,3));
    }
}
