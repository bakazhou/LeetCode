package DailyCode.topic384;

import java.util.Random;

class Solution {
    int[] array;
    int[] arrayClone;
    public Solution(int[] nums) {
        array = nums;
        arrayClone = nums.clone();
    }

    public int[] reset() {
        array = arrayClone.clone();
        return array;
    }

    //Ï´ÅÆËã·¨
    public int[] shuffle() {
        for (int i=array.length-1;i>=0;i--){
            Random random = new Random();
            int index = random.nextInt(i + 1);
            int num = array[index];
            array[index] = array[i];
            array[i] = num;

        }
        return array;
    }
}
