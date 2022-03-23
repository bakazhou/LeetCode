package DailyCode.topic461;

public class answer {
    public int hammingDistance(int x, int y) {
        String numx = Integer.toBinaryString(x);
        String numy = Integer.toBinaryString(y);
        int ans = 0,lenx=numx.length(),leny=numy.length();
        if (lenx>leny){
            int i=lenx-1,j=leny-1;
            for (;j>=0;j--,i--){
                if (numx.charAt(i)!=numy.charAt(j)) {
                    ans++;
                }
            }
            for (;i>=0;i--){
                if (numx.charAt(i)!='0'){
                    ans++;
                }
            }

        }else if (lenx<leny){
            int i=lenx-1,j=leny-1;
            for (;i>=0;i--,j--){
                if (numx.charAt(i)!=numy.charAt(j)) {
                    ans++;
                }
            }
            for (;j>=0;j--){
                if (numy.charAt(j)!='0'){
                    ans++;
                }
            }
        }else if (lenx==leny){
            for (int i=0;i<lenx;i++){
                if (numx.charAt(i)!=numy.charAt(i)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
