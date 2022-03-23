package DailyCode.topic13;

import java.util.HashMap;
import java.util.Map;

public class answer {
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int ans = 0;
        char[] chars = s.toCharArray();
        int[] ints = new int[s.length()];
        for (int i=chars.length-1;i>=0;i--){
            ints[i]=map.get(""+chars[i]);
        }
        for (int i=0;i<ints.length-1;i++){
            int cur = ints[i];
            int pre = ints[i+1];
            if (cur<pre) {
                ans-=cur;
            }else {
                ans+=cur;
            }
        }
        ans+=ints[ints.length-1];
        return ans;
    }
}
