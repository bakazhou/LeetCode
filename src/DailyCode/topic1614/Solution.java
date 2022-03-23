package DailyCode.topic1614;

import java.util.LinkedList;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê01ÔÂ07ÈÕ 12:27
 **/
class Solution {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int res = Integer.MIN_VALUE;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i=0;i<chars.length;i++){
            if (chars[i] == '('){
                stack.add('(');
                res = Math.max(res,stack.size());
            }
            else if (chars[i] == ')'){
                stack.removeLast();
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }
}
