package DailyCode.topic678;

import java.util.LinkedList;

public class Solution {
    public boolean checkValidString(String s) {
        LinkedList<Character> leftQueue = new LinkedList<>();
        LinkedList<Character> flagQueue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if (chars[i]=='('){
                leftQueue.add(chars[i]);
            }
            else if (chars[i]=='*'){
                flagQueue.add(chars[i]);
            }
            else if (chars[i]==')'){
                if (!leftQueue.isEmpty()){
                    leftQueue.removeLast();
                }else if (!flagQueue.isEmpty()){
                    flagQueue.removeLast();
                }
                else if (leftQueue.isEmpty() && flagQueue.isEmpty()){
                    return false;
                }
            }
        }
        return leftQueue.size()-flagQueue.size()<=0?true:false;
    }

}
