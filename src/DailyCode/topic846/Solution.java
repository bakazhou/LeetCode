package DailyCode.topic846;

import java.util.TreeMap;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ30ÈÕ 12:42
 **/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i< hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        while (!map.isEmpty()){
            int first = map.firstKey();
            for (int i=0;i<groupSize;i++){
                if (!map.containsKey(first)){
                    return false;
                }
                if (map.get(first) == 1){
                    map.remove(first);
                }else {
                    map.put(first,map.get(first)-1);
                }
                first++;
            }
        }
        return true;
    }
}