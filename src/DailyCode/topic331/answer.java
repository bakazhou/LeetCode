package DailyCode.topic331;

import java.util.LinkedList;

public class answer {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length(),right = 0;
        char[] chars = preorder.toCharArray();
        if (n==0) return false;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);
        while (right<n){
            if (stack.isEmpty()) return false;
            if (Character.isDigit(chars[right])) {
                int num = stack.getLast();
                num--;
                if (num!=0){
                    stack.add(num);
                }
                stack.add(2);
                right++;
            }
            if (chars[right]==',') right++;
            if (chars[right]=='#'){
                int num = stack.getLast();
                stack.removeLast();
                num--;
                if (num!=0){
                    stack.add(num);
                }
                right++;
            }
            if (stack.getLast()==0) stack.removeLast();
        }
        System.out.println(stack);
        return stack.isEmpty();
    }
}
