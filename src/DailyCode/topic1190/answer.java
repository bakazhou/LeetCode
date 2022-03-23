package DailyCode.topic1190;

import java.util.LinkedList;

public class answer {
    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        int n = chars.length;
        for (int i=0;i<n;i++){
            if (chars[i]=='(' || Character.isAlphabetic(chars[i])){
                stack.add(chars[i]+"");
            }
            else if (chars[i]==')'){
                StringBuilder tem = new StringBuilder();
                while (!stack.getLast().equals("(")){
                    tem.append(stack.getLast());
                    stack.removeLast();
                }
                stack.removeLast();
                tem.reverse();
                if (stack.isEmpty()){
                    sb.append(tem);
                }
                stack.add(tem.toString());
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.getLast());
            stack.removeLast();
        }
        sb.reverse();
        return sb.toString();
    }
}
