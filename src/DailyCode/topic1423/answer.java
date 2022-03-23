package DailyCode.topic1423;

public class answer {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0,left = 0,right = 0,min = 0,temp=0;
        for (int a: cardPoints) {
            sum+=a;
        }
        for (int i=0;i<cardPoints.length-k;i++){
            min += cardPoints[i];
            right++;
        }
        temp=min;
        while (right<cardPoints.length){
            temp=temp-cardPoints[left]+cardPoints[right];
            min =Math.min(min,temp);
            right++;
            left++;

        }

        return sum-min;
    }
}
