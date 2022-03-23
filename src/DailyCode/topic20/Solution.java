package DailyCode.topic20;

import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='(' || chars[i]=='{' || chars[i]=='['){
                stack.add(chars[i]);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char last = stack.getLast();
                if (chars[i]==')') {
                    if (last == '('){
                        stack.removeLast();
                    }else {
                        return false;
                    }
                }else if (chars[i]=='}'){
                    if (last == '{'){
                        stack.removeLast();
                    }else {
                        return false;
                    }
                }else if (chars[i]==']'){
                    if (last == '['){
                        stack.removeLast();
                    }else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid1(String s) {
        int grade = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{' ){
                grade++;
            }
        }
        return grade==0;
    }
}