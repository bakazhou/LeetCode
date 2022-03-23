package DailyCode.topic2079;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��09�� 18:53
 **/
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int step = 0;
        int curWater = capacity,location = -1;
        for (int i=0;i<plants.length;i++){
            //��ǰˮ��
            if (curWater >= plants[i]){
                curWater -= plants[i];
                step += Math.abs(i-location);
                location = i;
                //��ǰˮ��������һ�軨
                if (i != plants.length-1 && curWater < plants[i+1]){
                    curWater = capacity;
                    step += i+1;
                    location = -1;
                }
            }
        }
        return step;
    }
}