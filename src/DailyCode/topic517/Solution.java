package DailyCode.topic517;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0,n = machines.length;
        for (int i=0;i<n;i++){
            sum += machines[i];
        }
        if (sum%n!=0){//无法做到每台洗衣机件数相同
            return -1;
        }
        int step = 0,aver = sum/n,size = 0;
        int[] less = machines.clone();
        List<Integer> index = new ArrayList<>();
        for (int i=0;i<n;i++){
            less[i] = machines[i]-aver;
            if(less[i]<0){
                index.add(i);
            }
        }
        System.out.println(index);
        for (Integer i : index){
            step+=search(less,i);
            System.out.println(Arrays.toString(less));
        }

        return step;
    }
    public int search(int[] less,int index){
        int low = index-1,high = index+1,n = less.length,step = 0;
        while (low>=0 && high<n){
            if (low>=0 && less[low]>0 && less[index]!=0){
                int num = Math.abs(less[index]);
                if (num>less[low]){
                    less[index]=less[index]+less[low];
                    less[low]=0;
                }else {
                    less[index]=0;
                    less[low]=less[low]-num;
                }
                step+=(index-low);
            }
            if (high<0 && less[high]>0 && less[index]!=0){
                int num = Math.abs(less[index]);
                if (num>less[high]){
                    less[index]=less[index]+less[high];
                    less[high]=0;
                }else {
                    less[index]=0;
                    less[high]=less[high]-num;
                }
                step+=(high-index);
            }
            if (less[index]==0){
                break;
            }
            low--;
            high++;
        }
        return step;
    }
}
