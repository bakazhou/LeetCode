package DailyCode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }
    public static long fibonacci (int n) {
        List<Long> list = new ArrayList<>();
        list.add((long) 1);
        list.add((long) 1);

        for (int k = 2;k<n;k++){
            list.add(list.get(k-1)+list.get(k-2));
        }
        long sum =list.get(n);
        return sum;
    }

    public int single (int[] ar) {
        if (ar.length <= 1){
            return ar[0];
        }
        Arrays.sort(ar);
        int ans=-1;
        for (int i=0;i<ar.length;i=i+2){
            if (ar[i]!=ar[i+1]){
                return ar[i];
            }
        }
        return ans;
    }
}
