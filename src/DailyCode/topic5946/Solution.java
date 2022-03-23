package DailyCode.topic5946;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ26ÈÕ 11:15
 **/
class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<sentences.length;i++){
            String[] s = sentences[i].split(" ");
            max = Math.max(max,s.length);
        }
        return max;
    }
}