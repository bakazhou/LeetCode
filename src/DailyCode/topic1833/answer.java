package DailyCode.topic1833;

import java.util.Arrays;

public class answer {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length,sum = 0;
        for (int i=0;i<n;i++){
            if (coins>=costs[i]){
                coins=coins-costs[i];
                sum++;
            }else break;
        }
        return sum;
    }
}
