package DailyCode.topic1006;

import java.util.ArrayList;
import java.util.List;

public class answer {
    public int clumsy(int N) {
        List<Integer> integers = new ArrayList<>();
        int four = 0;
        while (N!=0){
            int sum = 0;
            for (int i=1;i<=4;i++){
                if (i==1){
                    sum = N;
                }
                else if (i==2){
                    sum = sum*N;
                }
                else if (i==3){
                    sum = sum/N;
                }
                else if (i==4){
                    four = four+N;
                }
                N--;
                if (N==0){
                    break;
                }
            }
            integers.add(sum);
        }
        int ans = four,n=integers.size();
        for (int i=0;i<n;i++){
            if (i==0) ans+=integers.get(i);
            else ans=ans-integers.get(i);
        }
        return ans;
    }
}
