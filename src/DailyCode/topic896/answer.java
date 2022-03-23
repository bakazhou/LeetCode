package DailyCode.topic896;

public class answer {
    public boolean isMonotonic(int[] A) {
        boolean flag=true,tem=true;
        if (A.length<=1) return true;
        int index=0;
        for (int i=0;i<A.length-1;i++){
            if (A[i]<A[i+1]) {
                tem=true;
                index=i;
                break;
            }
            else if (A[i]>A[i+1]) {
                tem=false;
                index=i;
                break;
            }
        }
        for (int i=index;i<A.length-1;i++){
            if (tem){
                if (A[i]>A[i+1]){
                    flag=false;
                    break;
                }
            }else {
                if (A[i]<A[i+1]){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }
}
