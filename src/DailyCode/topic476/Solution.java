package DailyCode.topic476;

public class Solution {
    public int findComplement(int num) {
        String string = Integer.toString(num, 2);
        char[] chars = string.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='0'){
                chars[i]='1';
            }
            else if (chars[i]=='1'){
                chars[i]='0';
            }
        }
        return Integer.parseInt(new String(chars),2);
    }
}
