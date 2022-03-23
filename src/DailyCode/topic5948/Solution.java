package DailyCode.topic5948;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月26日 11:16
 **/
class Solution {
    /**
     首先排除掉字符个数为奇数的情况，再从头遍历一次不可修改的右括号，从尾遍历一次不可修改的左括号，看是否能构成有效字符串就行了。
     **/
    boolean flag = false;
    Set<String> set = new HashSet<>();
    public boolean canBeValid(String s, String locked) {
        char[] chars = s.toCharArray();
        //记录可以改变的括号下标
        List<Integer> index = new ArrayList<>();
        //对原有字符串改变
        for (int i=0;i<locked.length();i++){
            if (locked.charAt(i) == '0'){
                index.add(i);
            }
        }
        dfs(chars,index,0);
        return flag;
    }
    public void dfs(char[] chars,List<Integer> index,int cur){
        if (cur == chars.length || flag){
            return;
        }
        if (isValid(new String(chars))){
            flag = true;
            return;
        }
        for (int i=cur;i<index.size();i++){
            chars[index.get(i)] = '(';
            dfs(chars,index,cur+1);
            chars[index.get(i)] = ')';
            dfs(chars,index,cur+1);
        }
    }
    public boolean isValid(String s) {
        System.out.println(s);

        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='('){
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
                }
            }
        }
        return stack.isEmpty();
    }
}