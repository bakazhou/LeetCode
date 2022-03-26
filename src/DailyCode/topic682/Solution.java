package DailyCode.topic682;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bakazhou
 **/
class Solution {
    public int calPoints(String[] ops) {
        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]){
                case "+":
                    score.add(score.get(score.size()-1)+score.get(score.size()-2));
                    break;
                case "D":
                    score.add(score.get(score.size()-1)*2);
                    break;
                case "C":
                    score.remove(score.size()-1);
                    break;
                default:
                    score.add(Integer.valueOf(ops[i]));
                    break;
            }
        }
        int res = 0;
        for (Integer num : score) {
            res += num;
        }
        return res;
    }
}
