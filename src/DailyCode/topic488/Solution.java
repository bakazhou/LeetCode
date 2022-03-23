package DailyCode.topic488;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int findMinStep(String board, String hand) {
        int operator = 0;
        LinkedList<String> queue = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<hand.length();i++){
            if (!map.containsKey(hand.charAt(i))){
                map.put(hand.charAt(i),1);
            }else {
                map.put(hand.charAt(i),map.get(hand.charAt(i))+1);
            }
        }
        queue.add(board);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i=0;i<n;i++){
                String first = queue.getFirst();
                queue.removeFirst();

            }
        }
        return queue.isEmpty()?operator:-1;
    }
    public boolean helper(){

        return true;
    }
}