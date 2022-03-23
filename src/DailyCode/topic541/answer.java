package DailyCode.topic541;

public class answer {
    public String reverseStr(String s, int k) {
        //每隔k个反转k个，末尾不够k个时全部反转
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = s.length(),knum=0;
        for (int i=0;i<n;){
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=i;j<i+k && j<n;j++){
                stringBuilder.append(chars[j]);
            }
            if (knum%2==0){
                sb.append(new StringBuffer(stringBuilder.toString()).reverse().toString());
            }else {
                sb.append(stringBuilder.toString());
            }
            i=i+stringBuilder.length();
            knum++;
        }
        return sb.toString();
    }
}
