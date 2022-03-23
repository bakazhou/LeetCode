package DailyCode.topic12;

import java.util.HashMap;
import java.util.Map;

public class answer {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(6,"VI");
        map.put(7,"VII");
        map.put(8,"VIII");
        map.put(9,"IX");

        map.put(10,"X");
        map.put(20,"XX");
        map.put(30,"XXX");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(60,"LX");
        map.put(70,"LXX");
        map.put(80,"LXXX");
        map.put(90,"XC");

        map.put(100,"C");
        map.put(200,"CC");
        map.put(300,"CCC");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(600,"DC");
        map.put(700,"DCC");
        map.put(800,"DCCC");
        map.put(900,"CM");

        map.put(1000,"M");
        map.put(2000,"MM");
        map.put(3000,"MMM");
        if (map.containsKey(num)) {
            return map.get(num);
        }

        char[] chars = new StringBuffer(Integer.toString(num)).reverse().toString().toCharArray();
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]-48!=0) {
                if (i==3){
                    sb.append(map.get((chars[i]-48)*1000));
                }
                else if (i==2){
                    sb.append(map.get((chars[i]-48)*100));
                }else if (i==1){
                    sb.append(map.get((chars[i]-48)*10));
                }else if (i==0){
                    sb.append(map.get((chars[i]-48)));
                }
            }
        }
        return sb.toString();
    }
}
