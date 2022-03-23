package DailyCode.topic605;

import java.util.Arrays;

public class answer {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int left=0,mid=1,right=2,leng=flowerbed.length;
        int[] flower = new int[leng+2];
        for (int i=1,j=0;i<leng+1;i++,j++){
            flower[i]=flowerbed[j];
        }
        while (right<leng){
            if (flower[left]==0 && flower[right]==0 && flower[mid]==0){
                flower[mid]=1;
                n--;
            }
            left++;
            mid++;
            right++;
        }
        System.out.println(Arrays.toString(flower));
        return n<=0;
    }
}
