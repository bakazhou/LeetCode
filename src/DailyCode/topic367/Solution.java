package DailyCode.topic367;

class Solution {
    public boolean isPerfectSquare(int num) {
        int n = 1;
        while(num>0){
            num = num - n;
            n += 2;
        }
        return num==0;
    }
}