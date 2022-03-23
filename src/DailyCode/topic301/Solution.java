package DailyCode.topic301;

import java.util.*;

class Solution {
    /*
    �������������Ҫɾ�����ٸ����ţ�
    ������ʱ����μ�֦����α�֤����ѳ������ǺϷ��Ľ����
    �Ƿ����ظ��Ĵ𰸣�
     */
    List<String> ans;
    Set<String> set;
    public List<String> removeInvalidParentheses(String s) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        int[] brackets = maxBrackets(s);
        //brackets[0]�Ƕ������������
        //brackets[1]�Ƕ������������
        if (brackets[0]+brackets[1]==s.length()){//ɾ����õ����ǿ�
            ans.add("");
            return ans;
        }
        if (brackets[0]+brackets[1]==0){//����Ҫɾ��
            ans.add(s);
            return ans;
        }
        dfs(s,0,0,0,"",brackets[0],brackets[1]);
        return ans;
    }
    //��ǰ�ַ���,cur�Ѱ�������������,cur�Ѱ�������������,��ǰ��ɴ�cur,�����ſ�ɾ������,�����ſ�ɾ������
    public void dfs(String s,int leftNum,int rightNum,int index,String cur,int brackLeft,int brackRight){
        if (index == s.length()){//�Ѿ��������
            if (isValid(cur) && brackLeft==0 && brackRight==0 && !set.contains(cur)){
                ans.add(cur);
            }
            return;
        }
        if (rightNum>leftNum || brackLeft<0 || brackRight<0){//��������������������,������
            return;
        }
        //��ǰλ������ĸ ֱ�Ӽ���
        if (Character.isAlphabetic(s.charAt(index))){
            dfs(s,leftNum,rightNum,index+1,cur+s.charAt(index),brackLeft,brackRight);
        }
        else if (s.charAt(index)=='('){
            if (brackLeft>0){
                //��Ҫ��ǰ��������
                dfs(s, leftNum, rightNum, index+1, cur, brackLeft-1, brackRight);
            }else {
                //Ҫ��ǰ��������
                dfs(s, leftNum+1, rightNum, index+1, cur+'(', brackLeft, brackRight);
            }
        }
        else if (s.charAt(index)==')'){
            //�����Ŷ���������,��ôҪ��ǰ��������
            if (leftNum>rightNum){
                dfs(s, leftNum, rightNum+1, index+1, cur+')', brackLeft, brackRight);
            }else {
                //��Ҫ��ǰ������
                dfs(s, leftNum, rightNum, index+1, cur, brackLeft, brackRight-1);
            }
        }
    }

    public int[] maxBrackets(String s){
//        ���������Ҫɾ������������,��������������ź�������
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