package DailyCode.topic2105;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月13日 11:38
 **/
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int alice = capacityA,bob = capacityB;
        int left = 0,right = plants.length-1,ans = 0;
        while (left <= right){
            //两人在同一个位置
            if (left == right){
                int max = Math.max(alice,bob);
                if (max < plants[left]){
                    ans++;
                }
                break;
            }
            if (plants[left] <= alice){
                alice -= plants[left];
            }else {
                ans++;
                alice = capacityA - plants[left];
            }
            if (plants[right] <= bob){
                bob -= plants[right];
            }else {
                ans++;
                bob = capacityB - plants[right];
            }
            right--;
            left++;
        }
        return ans;
    }
}