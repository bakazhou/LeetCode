package DailyCode.topic434;

public class Solution {
    public int countSegments(String s) {
        String[] s1 = s.split(" ");
        int ans = 0;
        for (String string:s1){
            if (!string.equals(" ")){
                ans++;
            }
        }
        return ans;
    }
}
