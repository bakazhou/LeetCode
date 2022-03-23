package DailyCode.topic5926;

import java.util.LinkedList;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int second = 0;
        while (tickets[k] != 0){
            for (int i=0;i<tickets.length;i++){
                if (tickets[i]!=0){
                    tickets[i]--;
                    second++;
                }
                if (tickets[k]==0){
                    return second;
                }
            }
        }
        return second;
    }
}