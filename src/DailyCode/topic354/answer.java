package DailyCode.topic354;

import java.util.Arrays;
import java.util.Comparator;

public class answer {
    public int maxEnvelopes(int[][] envelopes) {
        int ans = 0,n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /*
                o1[0]正序
                o1[1]逆序
                 */
                if (o1[0]>o2[0]) return 1;
                else if (o1[0]==o2[0]){
                    if (o1[1]<o2[1]){
                        return 1;
                    }else if (o1[1]==o2[1]){
                        return 0;
                    }
                    return -1;
                }
                return -1;
            }
        });
        int[] Lis = new int[n];
        int[] flag = new int[n];
        for (int i = 0;i<n;i++){
            
            flag[i]=envelopes[i][1];
        }
        Lis[0]=1;
        for (int i = 1;i<n;i++){
            for (int j = 0;j<i;j++){
                int m = 1;
                if (flag[i]>=flag[j]){
                    m = Math.max(m,Lis[j]+1);
                }
                Lis[j]=m;
            }
        }
        System.out.println(Arrays.toString(Lis));
        Arrays.sort(Lis);
        return Lis[n-1];
    }
}
