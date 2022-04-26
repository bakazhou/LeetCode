package DailyCode.topic386;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author bakazhou
 **/
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                final String num1 = o1.toString();
                final String num2 = o2.toString();
                int length = Math.min(num1.length(),num2.length());
                for (int i = 0; i < length; i++) {
                    if (num2.charAt(i) > num1.charAt(i)){
                        return 1;
                    }
                    if (num2.charAt(i) < num1.charAt(i)){
                        return -1;
                    }
                }
                return num1.length()>num2.length()?-1:1;
            }
        });
        return list;
    }
}
