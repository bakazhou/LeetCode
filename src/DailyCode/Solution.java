package DailyCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int p = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] people = new int[p];
        for (int i=0;i<p;i++){
            people[i] = scanner.nextInt();
        }
        boolean flag = true;
        Arrays.sort(people);
        for (int i=0;i<p;i++){
            int socre = people[i];
            int location = 0;
            for (int j=0;j<=p;j++){
                if (people[j]>socre){
                    location = j-1;
                    break;
                }
            }
            if (location+1>=x && location+1<=y && p-(location+1)>=x && p-(location+1)<=y) {
                flag=false;
                System.out.println(socre);
                break;
            }
        }
        if (flag){
            System.out.println(-1);
        }
    }
}
