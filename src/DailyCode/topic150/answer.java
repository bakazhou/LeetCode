package DailyCode.topic150;

import java.util.LinkedList;

public class answer {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        int n=tokens.length,ans=0;
        for (int i=0;i<n;i++){
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                list.offerLast(Integer.parseInt(tokens[i]));
            }else {
                int num1 = list.getLast();
                list.removeLast();
                int num2 = list.getLast();
                list.removeLast();
                if (tokens[i].equals("+")) list.offerLast(num2+num1);
                else if (tokens[i].equals("-")) list.offerLast(num2-num1);
                else if (tokens[i].equals("*")) list.offerLast(num2*num1);
                else if (tokens[i].equals("/")) list.offerLast(num2/num1);
            }
        }
        return list.getLast();
    }
}
