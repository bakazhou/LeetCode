package DailyCode.topic91;

import java.util.ArrayList;
import java.util.List;

public class answer {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0]=='0') return 0;
        int ans = 0;
        List<Character> characters = new ArrayList<>();//把每个0和其前置数字全部取出来因为其是固定的
        for (int i=0;i<chars.length-1;i++){
            if (chars[i+1]!='0' && chars[i]!='0'){
                characters.add(chars[i]);
            }
        }
        if (chars[chars.length-1]!='0') characters.add(chars[chars.length-1]);
        System.out.println(characters);
        return ans;
    }
}
