package DailyCode.topic1736;

public class answer {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        for (int i=chars.length-1;i>=3;i--){
            if (chars[i]=='?'){
                if (i==chars.length-1){
                    chars[i]='9';
                }
                else if (i==chars.length-2){
                    chars[i]='5';
                }
            }
        }
        if (chars[0]=='?' && chars[1]=='?'){
            chars[0]='2';
            chars[1]='3';
            return new String(chars);
        }
        if (chars[0]=='?'){
            if (chars[1]>'3'){
                chars[0]='1';
            }else {
                chars[0]='2';
            }
            return new String(chars);
        }
        if (chars[1]=='?') {
            if (chars[0]=='1'){
                chars[1]='9';
            }else {
                chars[1]='3';
            }
        }
        return new String(chars);
    }
}
