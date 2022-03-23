package DailyCode.topic204;

public class answer {
    public int countPrimes(int n) {
        if (n<=1) return 0;
        int ans = 0;
        for (int i=1;i<=n;i++){
            if (judge(i)) ans++;
        }
        return ans;
    }
    public boolean judge(int num){
         for (int i=2;i<num;i++){
             if ((double)(num)/i==0){
                 System.out.println("====");
                 return false;
             }
         }
         return true;
    }
}
