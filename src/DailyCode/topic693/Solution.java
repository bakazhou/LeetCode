package DailyCode.topic693;

/**
 * @author bakazhou
 **/
public class Solution {
    public boolean hasAlternatingBits(int n) {
        final String string = Integer.toString(n, 2);
        final char[] chars = string.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]){
                return false;
            }
        }
        return true;
    }
}
