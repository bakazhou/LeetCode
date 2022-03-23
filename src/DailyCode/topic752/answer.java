package DailyCode.topic752;

import java.util.*;

public class answer {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        Set<String> deads = new HashSet<>();
        for (String str : deadends){
            deads.add(str);
        }
        if (deads.contains(target) || deads.contains("0000")){
            return -1;
        }
        queue.add("0000");
        set.add("0000");
        int step = 0;
        while (!queue.isEmpty()){
            step++;
            int n = queue.size();
            for (int j=0;j<n;j++){
                String string = queue.getFirst();
                queue.removeFirst();
                if (string.equals(target)){
                    return step;
                }
                for (int i=0;i<4;i++){
                    String up = plusOne(string,i);
                    String down = minusOne(string,i);
                    if (!set.contains(up) && !deads.contains(up)){
                        set.add(up);
                        queue.add(up);
                    }
                    if (!set.contains(down) && !deads.contains(down)){
                        set.add(down);
                        queue.add(down);
                    }
                }
            }
        }
        return -1;
    }
    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
