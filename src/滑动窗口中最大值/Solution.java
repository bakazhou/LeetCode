package 滑动窗口中最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /*
    给一个arr数组，规定滑动窗口大小为w
    返回构成的每个滑动窗口中最大值构成的集合
    主要思想就是维持一个从大到小的队列
    需要注意的就是队列中最大值下标的过期问题,即不在滑动窗口中的情况
     */
    public static List<Integer> maxList(int[] arr,int w){
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        //维持队列中数字排列为从大到小，队列中存储的是数字所在下标
        for (int i=0;i<w;i++){
            int num = arr[i];
            if (queue.isEmpty()){
                queue.add(i);
            }else {
                while (!queue.isEmpty() && arr[queue.getLast()]<=num){
                    queue.removeLast();
                }
                queue.add(i);
            }
        }
        int low = 0,high = w;
        while (high<arr.length){
            ans.add(arr[queue.getFirst()]);
            if (low==queue.getFirst()){//队列中的最大值需要进行过期操作,即当前最大值的下标处于low处
                queue.removeFirst();
            }
            low++;

            if (queue.isEmpty()){//队列为空
                queue.add(high);
            }else {
                while (!queue.isEmpty() && arr[queue.getLast()]<=arr[high]){
                    queue.removeLast();
                }
                queue.add(high);
            }
            high++;
        }
        ans.add(arr[queue.getFirst()]);
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {6,2,4,5,8,4,6,9};
        System.out.println(maxList(num,3));
    }
}
