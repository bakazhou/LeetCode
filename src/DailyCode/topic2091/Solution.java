package DailyCode.topic2091;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��08�� 18:35
 **/
class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        int maxIndex = -1,minIndex = -1;
        for (int i=0;i<nums.length;i++){
            if (nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        int ope = 0;
        //��ɾ�����������˽Ͻ���һ��,Ȼ���ҵ�ɾ����������±�λ��
        int maxDis = Math.min(maxIndex+1,nums.length-maxIndex);
        int minDis = Math.min(minIndex+1,nums.length-minIndex);
        int index = -1;
        ope += Math.min(maxDis,minDis);
        //��ɾ�����ֵ
        if (minDis > maxDis){
            if (maxDis == maxIndex+1){
                index = maxIndex+1;
            }else {
                index = nums.length-maxDis;
            }
            if (index > minIndex){
                ope += Math.min(index-minIndex,minDis);
            }else {
                ope += Math.min(minIndex+1-index,minDis);
            }
        }else {
            if (minDis == minIndex+1){
                index = minIndex+1;
            }else {
                index = nums.length-minDis;
            }
            if (index > maxIndex){
                ope += Math.min(index-maxIndex,maxDis);
            }else {
                ope += Math.min(maxIndex+1-index,maxDis);
            }
        }
        return ope;
    }
}