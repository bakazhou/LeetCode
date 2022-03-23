package DailyCode.topic537;

/**
 * @author bakazhou
 * @description
 * @date 2022年02月25日 13:35
 **/
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        final String[] split1 = num1.split("\\+");
        final String[] split2 = num2.split("\\+");
        int s1 = Integer.parseInt(split1[0]);
        int s2 = Integer.parseInt(split2[0]);
        int x1 = Integer.parseInt(split1[1].substring(0,split1[1].length()));
        int x2 = Integer.parseInt(split2[1].substring(0,split2[1].length()));
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(s1*s2+x1*x2*(-1)).append('+').append(s1*x2+s2*x1).append("i").toString();
    }
}