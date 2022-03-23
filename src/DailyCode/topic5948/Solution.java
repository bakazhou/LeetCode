package DailyCode.topic5948;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��26�� 11:16
 **/
class Solution {
    /**
     �����ų����ַ�����Ϊ������������ٴ�ͷ����һ�β����޸ĵ������ţ���β����һ�β����޸ĵ������ţ����Ƿ��ܹ�����Ч�ַ��������ˡ�
     **/
    boolean flag = false;
    Set<String> set = new HashSet<>();
    public boolean canBeValid(String s, String locked) {
        char[] chars = s.toCharArray();
        //��¼���Ըı�������±�
        List<Integer> index = new ArrayList<>();
        //��ԭ���ַ����ı�
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