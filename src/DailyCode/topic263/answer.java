package DailyCode.topic263;

public class answer {
    public boolean judge(int target){
        if (target == 0 ) return false;
        if (target==2 || target==3 || target==5) return true;
        else if (target%2==0){
            return judge(target/2);
        }
        else if (target%3==0){
            return judge(target/3);
        }
        else if (target%5==0){
            return judge(target/5);
        }
        return false;
    }
    public boolean isUgly(int n) {
        if (n==1) return true;
        boolean flag = judge(n);
        return flag;
    }

    public static void main(String[] args) {
        short a = 1;
    }
}
