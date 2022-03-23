package ����;

import java.util.Arrays;

public class shellSort {
    /*
    https://www.cnblogs.com/chengxiao/p/6104371.html
    ϣ������  ���ȶ������㷨
    ˼��Ϊ����һ������gap��ʼֵΪ���鳤��/2,�����������Ϊgap�����
    ��ÿ����Ͻ��в�������,�ھ�������֮��ÿ����϶�������һ������״̬
    ����ֵ�ϵͺ󣬽���Ҫ�ƶ�����Ԫ�ؼ��������������
    �ռ临�Ӷ� O(1)
    ʱ�临�Ӷ� O(n^��1.3��2��)
     */
    public static void main(String []args){
        int []arr ={1,4,2,7,9,8,3,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ϣ������ ������������ڲ���ʱ���ý�����
     */
    public static void sort(int []arr){
        //����gap��������С����
        for(int gap=arr.length/2;gap>0;gap/=2){
            //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
            for(int i=gap;i<arr.length;i++){
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    //����������ý�����
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    /**
     * ��������Ԫ��
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
