package DailyCode.topic87;

import java.util.HashSet;
import java.util.Set;

public class answer {
    Set<String> set;
    public boolean isScramble(String s1, String s2) {
        Set<Character> characters = new HashSet<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i=0;i<c1.length;i++){
            characters.add(c1[i]);
        }
        for (int i=0;i<c2.length;i++){
            if (!characters.contains(c2[i])) return false;
        }
        return true;
    }
    public void judge(String before,String after,int beIndex,int afIndex){
        String ans = before+after;
        if (set.contains(ans)) return;
        else set.add(ans);
        if (before.length()>1){

        }
        if (after.length()>1){

        }
    }

    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a.substring(2,3));
    }
}
