package DailyCode.topic724;

public class answer {
    /*
    解题思路：
    因为是寻找中心索引，所以就从左向右找
    先做一个全数的和sum1
    sum2用来从左向右加

    输入：
    nums = [1, 7, 3, 6, 5, 6]
    输出：3
    解释：
    索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
    同时, 3 也是第一个符合要求的中心索引
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
            sum1+=nums[index];//因为此处要还原sum1的值
            /*
            sum1: 7 3 6 5 6
            sum2: 1
             */
        }
        return -1;
    }
}
