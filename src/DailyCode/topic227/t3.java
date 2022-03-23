package DailyCode.topic227;

import java.util.ArrayList;
import java.util.Stack;

public class t3 {
    public static void main(String[] args) {
        String expression = behindToAfter("1+2*5/3+6/4*2".replaceAll(" ",""));
        System.out.println(calcu(expression));
    }
    public static String behindToAfter(String expresion){
        String ans = "";
        Stack<Character> stack = new Stack<>();
        Stack<Character> sub = new Stack<>();
        char[] chars = expresion.toCharArray();
        int index = 0,n = expresion.length();
        while (index<n){
            if (Character.isDigit(chars[index])) {
                if (index+1<n){
                    if (Character.isDigit(chars[index+1])) ans+=chars[index];
                    else ans=ans+chars[index]+' ';
                }
                else if (index==n-1) ans=ans+chars[index]+' ';
            }
            else if (chars[index]=='+' || chars[index]=='*' || chars[index]=='/' || chars[index]==')' || chars[index]=='('){
                if (stack.empty()) stack.add(chars[index]);
                else {
                    //则判断其与楼顶符号的优先级，是右括号或优先级低,栈顶符号(乘除优先加减)则栈顶元素依次出钱并输出 ，
                    char top = stack.peek();
                    if (chars[index]==')'){
                        while (!sub.empty()){
                            ans+=sub.pop();
                            ans+=' ';
                        }
                        while (stack.peek()!='('){
                            ans+=stack.pop();
                            ans+=' ';
                        }
                        stack.pop();
                    }
                    else if (top=='+' || top=='('){
                        stack.add(chars[index]);
                    }else if (top=='*' || top=='/'){
                        while (!stack.empty() && (stack.peek()=='*' || stack.peek()=='/')){
                            ans+=stack.pop();
                            ans+=' ';
                        }
                        stack.add(chars[index]);

                    }

                }
            }else if (chars[index]=='-'){
                if (!stack.empty()) {
                    char top = stack.peek();
                    if (top == '*' || top == '/') {
                        while (!stack.empty()) {
                            ans += stack.pop();
                            ans += ' ';
                        }
                    }
                }
                sub.add('+');
                ans+='-';
            }
            index++;
        }
        while (!stack.empty()){
            ans+=stack.pop();
            ans+=' ';
        }
        while (!sub.empty()){
            ans+=sub.pop();
            ans+=' ';
        }
        System.out.println(ans);
        return ans;
    }
    public static int calcu(String expresion){
        ArrayList<String> list = new ArrayList<>();
        char[] chars = expresion.toCharArray();
        int left=0,right=0,length=expresion.length();
        while (right<length && left<length){
            if (chars[right]==' '){
                String str = expresion.substring(left,right);
                list.add(str);
                left=right+1;
                right=left;
            }
            right++;
        }
        Stack<String> stack = new Stack<>();
        int n = list.size();
        for (int i=0;i<n;i++){
            if (list.get(i).equals("+") || list.get(i).equals("-") || list.get(i).equals("*") || list.get(i).equals("/")){
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                if (list.get(i).equals("+")) stack.add(String.valueOf(num2+num1));
                else if (list.get(i).equals("-")) stack.add(String.valueOf(num2-num1));
                else if (list.get(i).equals("*")) stack.add(String.valueOf(num2*num1));
                else if (list.get(i).equals("/")) stack.add(String.valueOf(num2/num1));
            }else stack.add(list.get(i));
        }
        return Integer.parseInt(stack.pop());
    }
}
