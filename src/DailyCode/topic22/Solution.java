package DailyCode.topic22;

import java.util.*;

class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        dfs(new StringBuilder(),n*2,0,0);
        return ans;
    }
    public void dfs(StringBuilder sb,int leng,int open,int close){
        if (sb.length() == leng){
            if (isValid(sb.toString())){
                ans.add(sb.toString());
            }
            return;
        }
        if (open<3){
            dfs(new StringBuilder(sb).append('('),leng,open+1,close);
        }
        if (close<open){
            dfs(new StringBuilder(sb).append(')'),leng,open,close+1);
        }
    }
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
}
