package DailyCode.topic738;

public class answer {
    public int monotoneIncreasingDigits(int N) {
        while (!judge(N)){
            N--;
        }
        return N;
    }
    public boolean judge(int N){
        char[] chars = Integer.toString(N).toCharArray();
        for (int i=0;i<chars.length-1;i++){
            if (chars[i]>chars[i+1]) return false;
        }
        return true;
    }
}
