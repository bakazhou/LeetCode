package DailyCode.topic551;

public class answer {
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int lateNum = 0,absentNum = 0,n = s.length();
        for (int i=0;i<n;i++){
            if (absentNum>=2){
                return false;
            }
            if (lateNum>=3){
                return false;
            }
            if (chars[i]=='A'){
                absentNum++;
                lateNum=0;
            }
            else if (chars[i]=='P'){
                lateNum = 0;
            }
            else if (chars[i]=='L'){
                lateNum++;
            }
        }
        if (lateNum>=3){
            return false;
        }
        return true;
    }
}
