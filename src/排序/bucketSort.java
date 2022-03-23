package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bucketSort {
    /*
    Ͱ����
    ʱ�临�Ӷȣ�O(N + C)
    �ռ临�Ӷȣ�O(N + M)
    ˼��Ϊ�������е����ַ��������䲻ͬ��Ͱ��,��ÿ��Ͱ��������
    ���ÿ��Ͱ�����һ��,�õ��ľ���������ɵ�����
     */
    public static void bucketSort(int[] arr){

        // �������ֵ����Сֵ
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // ����Ͱ������
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        // ��ÿ��Ԫ�ط���Ͱ
        for(int i = 0; i < arr.length; i++){
            //num��Ͱ�Ķ�Ӧ���
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        // ��ÿ��Ͱ��������
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        // ��Ͱ�е�Ԫ�ظ�ֵ��ԭ����
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
