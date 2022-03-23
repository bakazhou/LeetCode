package DailyCode.topic1816;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ06ÈÕ 10:43
 **/
class Solution {
    public String truncateSentence(String s, int k) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<k;i++){
            sb.append(split[i]);
            if (i != k-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}