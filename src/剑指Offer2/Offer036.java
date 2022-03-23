package ½£Ö¸Offer2;

import java.util.LinkedList;

public class Offer036 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+")){
                int num1 = stack.getLast();
                stack.removeLast();
                int num2 = stack.getLast();
                stack.removeLast();
                stack.add(num1+num2);
            }
            else if (tokens[i].equals("-")){
                int num1 = stack.getLast();
                stack.removeLast();
                int num2 = stack.getLast();
                stack.removeLast();
                stack.add(num2-num1);
            }
            else if (tokens[i].equals("*")){
                int num1 = stack.getLast();
                stack.removeLast();
                int num2 = stack.getLast();
                stack.removeLast();
                stack.add(num2*num1);
            }
            else if (tokens[i].equals("/")){
                int num1 = stack.getLast();
                stack.removeLast();
                int num2 = stack.getLast();
                stack.removeLast();
                stack.add(num2/num1);
            }else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.getLast();
    }
}
