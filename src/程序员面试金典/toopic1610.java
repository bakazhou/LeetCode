package ����Ա���Խ��;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��09�� 15:14
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
