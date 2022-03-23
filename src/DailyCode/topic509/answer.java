package DailyCode.topic509;

public class answer {
    public int fib(int n) {
        int[] note = new int[n+1];
        if(n<0){
            return 0;
        }
        return searchFib(note,n);
    }
    public int searchFib(int[] note,int n){
        if (n==1 || n==2) return 1;
        if (note[n]!=0){
            return note[n];
        }
        note[n]=searchFib(note,n-1)+searchFib(note, n-2);
        return note[n];
    }
}
