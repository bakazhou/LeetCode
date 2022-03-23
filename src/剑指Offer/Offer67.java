package 剑指Offer;

public class Offer67 {
    public int strToInt(String str) {

        char[] chars = str.toCharArray();
        if (chars.length==0){
            return 0;
        }

        int index = 0;
        while (chars[index]!=' '){
            index++;
        }

        if (chars[index]!='+' && chars[index]!='-' && !Character.isDigit(chars[index])){
            return 0;
        }
        boolean flag = true;
        if (chars[index]=='-'){
            flag=false;
        }
        StringBuilder sb = new StringBuilder();
        if (Character.isDigit(chars[index]) && chars[index]!='0'){
            sb.append(chars[index]);
            index++;
        }
        for (int i=index;i<chars.length;i++){
            if (Character.isDigit(chars[i])){
                if (sb.length()==0 && chars[i]=='0'){
                    continue;
                }
                sb.append(chars[i]);
            }else {
                break;
            }
        }
        if (sb.length()==0){
            return 0;
        }
        if (sb.length()>10){
            if (flag){
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }
        else if (sb.length()==10){
            String zheng = "2147483647";
            String fu = "2147483648";
            int num = 214748364;
            String string = sb.toString();
            int tail = string.charAt(string.length()-1);
            int head = Integer.parseInt(string.substring(0,string.length()-1));
            if (flag){
                if (head>num){
                    return Integer.MAX_VALUE;
                }
                if (head==num && tail>7){
                    return Integer.MAX_VALUE;
                }
            }else {
                if (head>num){
                    return Integer.MIN_VALUE;
                }
                if (head==num && tail>7){
                    return Integer.MIN_VALUE;
                }
            }
        }
        return flag?Integer.parseInt(sb.toString()):-Integer.parseInt(sb.toString());
    }
}
