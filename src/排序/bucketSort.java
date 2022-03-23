package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bucketSort {
    /*
    桶排序
    时间复杂度：O(N + C)
    空间复杂度：O(N + M)
    思想为将数组中的数字放入多个区间不同的桶中,对每个桶进行排序
    最后将每个桶组合在一起,得到的就是排序完成的数组
     */
    public static void bucketSort(int[] arr){

        // 计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            //num是桶的对应序号
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            for(int j = 0; j < bucketArr.get(i).size(); j++){
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {2,4,1,3,80,70,44};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
