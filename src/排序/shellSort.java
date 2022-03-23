package 排序;

import java.util.Arrays;

public class shellSort {
    /*
    https://www.cnblogs.com/chengxiao/p/6104371.html
    希尔排序  非稳定排序算法
    思想为设置一个增量gap初始值为数组长度/2,将整个数组分为gap个组合
    对每个组合进行插入排序,在经过数次之后每个组合都趋近于一个有序状态
    增量值较低后，仅需要移动少数元素即可完成整个排序
    空间复杂度 O(1)
    时间复杂度 O(n^（1.3—2）)
     */
    public static void main(String []args){
        int []arr ={1,4,2,7,9,8,3,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     */
    public static void sort(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    //插入排序采用交换法
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    /**
     * 交换数组元素
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
