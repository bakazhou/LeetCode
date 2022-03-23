package DailyCode.topic50;

public class answer {
    public double myPow(double x, int n) {
        if (x==1.00000) return x;
        double ans = 1;
        for (int i=0;i<Math.abs(n);i++){
            ans=ans*x;
        }
        if (n<0) return 1.00000/ans;
        return ans;
    }
}
