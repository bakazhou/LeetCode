package DailyCode.topic724;

public class answer {
    /*
    ����˼·��
    ��Ϊ��Ѱ���������������Ծʹ���������
    ����һ��ȫ���ĺ�sum1
    sum2�����������Ҽ�

    ���룺
    nums = [1, 7, 3, 6, 5, 6]
    �����3
    ���ͣ�
    ���� 3 (nums[3] = 6) �������֮�� (1 + 7 + 3 = 11)�����Ҳ���֮�� (5 + 6 = 11) ��ȡ�
    ͬʱ, 3 Ҳ�ǵ�һ������Ҫ�����������
     */
    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int sum1=0;
        for (int i=0;i<nums.length;i++){
            sum1+=nums[i];
        }
        int index=0,sum2=0;
        if (sum1-nums[index]==sum2){
            return index;
        }
        while (index!=nums.length-1){
            sum1-=nums[index];
            sum2+=nums[index];
            /*
            sum1: 7 3 6 5 6
            sum2: 1
             */
            index++;
            sum1-=nums[index];
            /*
            sum1: 3 6 5 6
            sum2: 1
             */
            if (sum1==sum2){
                return index;
            }
            sum1+=nums[index];//��Ϊ�˴�Ҫ��ԭsum1��ֵ
            /*
            sum1: 7 3 6 5 6
            sum2: 1
             */
        }
        return -1;
    }
}
