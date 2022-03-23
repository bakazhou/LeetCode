package 剑指Offer2;

import java.util.LinkedList;

public class Offer037 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = asteroids.length;
        for (int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.add(asteroids[i]);
            }else {
                boolean as = judge(asteroids[i]);//判断新的小行星是向左还是向右
                boolean stackAs = judge(stack.getLast());//判断stack中的小行星是向左还是向右
                boolean flag = true;//判断小行星是否还存在
                if (as == stackAs || as==true && stackAs==false){//栈中小行星方向向左,新小行星向右
                    stack.add(asteroids[i]);
                }else if (as==false && stackAs==true){
                    while (!stack.isEmpty() && judge(stack.getLast())!=as){//直到stack中都是同一方向的小行星
                        if (Math.abs(stack.getLast())-Math.abs(asteroids[i])>0){//新的小行星被撞毁
                            flag=false;
                            break;
                        }
                        else if (Math.abs(stack.getLast())-Math.abs(asteroids[i])==0){//两个小行星都撞毁
                            stack.removeLast();
                            flag=false;
                            break;
                        }
                        else if (Math.abs(stack.getLast())-Math.abs(asteroids[i])<0){//新的小行星比栈中小行星大
                            while(!stack.isEmpty() && judge(stack.getLast())!=as && Math.abs(stack.getLast())-Math.abs(asteroids[i])<0){//新小行星摧毁栈中小行星,直到遇到同方向小行星或遇到更大的小行星
                                stack.removeLast();
                            }
                        }
                    }
                    if (flag){//小行星还在
                        stack.add(asteroids[i]);
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            ans[index] = stack.getFirst();
            stack.removeFirst();
            index++;
        }
        return ans;
    }
    public boolean judge(int num){
        if (num>=0){
            return true;
        }
        return false;
    }
}
