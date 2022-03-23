package DailyCode.topic301;

import java.util.*;

class Solution {
    /*
    求出到底最少需要删除多少个括号？
    搜索的时候如何剪枝，如何保证最后搜出来的是合法的结果。
    是否有重复的答案？
     */
    List<String> ans;
    Set<String> set;
    public List<String> removeInvalidParentheses(String s) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        int[] brackets = maxBrackets(s);
        //brackets[0]是多出来的左括号
        //brackets[1]是多出来的右括号
        if (brackets[0]+brackets[1]==s.length()){//删除后得到就是空
            ans.add("");
            return ans;
        }
        if (brackets[0]+brackets[1]==0){//不需要删除
            ans.add(s);
            return ans;
        }
        dfs(s,0,0,0,"",brackets[0],brackets[1]);
        return ans;
    }
    //当前字符串,cur已包含左括号数量,cur已包含右括号数量,当前组成串cur,左括号可删除数量,右括号可删除数量
    public void dfs(String s,int leftNum,int rightNum,int index,String cur,int brackLeft,int brackRight){
        if (index == s.length()){//已经到了最后
            if (isValid(cur) && brackLeft==0 && brackRight==0 && !set.contains(cur)){
                ans.add(cur);
            }
            return;
        }
        if (rightNum>leftNum || brackLeft<0 || brackRight<0){//右括号数量多余左括号,不符合
            return;
        }
        //当前位置是字母 直接加入
        if (Character.isAlphabetic(s.charAt(index))){
            dfs(s,leftNum,rightNum,index+1,cur+s.charAt(index),brackLeft,brackRight);
        }
        else if (s.charAt(index)=='('){
            if (brackLeft>0){
                //不要当前的左括号
                dfs(s, leftNum, rightNum, index+1, cur, brackLeft-1, brackRight);
            }else {
                //要当前的左括号
                dfs(s, leftNum+1, rightNum, index+1, cur+'(', brackLeft, brackRight);
            }
        }
        else if (s.charAt(index)==')'){
            //左括号多于右括号,那么要当前的右括号
            if (leftNum>rightNum){
                dfs(s, leftNum, rightNum+1, index+1, cur+')', brackLeft, brackRight);
            }else {
                //不要当前右括号
                dfs(s, leftNum, rightNum, index+1, cur, brackLeft, brackRight-1);
            }
        }
    }

    public int[] maxBrackets(String s){
//        求出最少需要删除的括号数量,即多出来的右括号和左括号
        int moreLeft=0,moreRight=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                moreLeft++;
            }
            else if (s.charAt(i)==')' &&  moreLeft!=0){
                moreLeft--;
            }
            else if (s.charAt(i)==')' &&  moreLeft==0){
                moreRight++;
            }
        }
        return new int[]{moreLeft,moreRight};
    }
    public boolean isValid(String s){
        int grade = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                grade++;
            }
            else if (s.charAt(i)==')'){
                grade--;
            }
            if (grade<0){
                return false;
            }
        }
        return grade==0;
    }
}