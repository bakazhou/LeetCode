package DailyCode.topic495;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int seceond = 0,endTime = 0;
        for (int i=0;i<timeSeries.length;i++){
            if (endTime==0){
                seceond += duration;
                endTime = timeSeries[i]+duration-1;
            }else {
                if (timeSeries[i]<endTime){
                    seceond += timeSeries[i]+duration-1-endTime;
                    endTime = timeSeries[i]+duration-1;
                }else {
                    seceond += duration;
                    endTime = timeSeries[i]+duration-1;
                }
            }
        }
        return seceond;
    }
}