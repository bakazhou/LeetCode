package 程序员面试金典;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 15:14
 **/
public class toopic1610 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] year = new int[101];
        for (int i=0;i<birth.length;i++){
            for (int j=birth[i];j<=death[i];j++){
                year[j%1900]++;
            }
        }
        int y = Integer.MIN_VALUE,ans = 0;
        for (int i=0;i<year.length;i++){
            if (year[i] > y){
                y = year[i];
                ans = i;
            }
        }
        return ans+1900;
    }
}
