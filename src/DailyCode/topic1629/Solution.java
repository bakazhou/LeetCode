package DailyCode.topic1629;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ10ÈÕ 11:34
 **/
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int max = releaseTimes[0];
        for (int i=1;i<releaseTimes.length;i++){
            if (releaseTimes[i] - releaseTimes[i-1] > max){
                max = releaseTimes[i];
                max = releaseTimes[i] - releaseTimes[i-1];
            }
            else if (releaseTimes[i] - releaseTimes[i-1] == max){
                if (keysPressed.charAt(i) > keysPressed.charAt(i-1)){
                    res = keysPressed.charAt(i);
                }
            }
        }
        return res;
    }
}
