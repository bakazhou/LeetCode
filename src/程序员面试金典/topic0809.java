package ����Ա���Խ��;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��09�� 13:32
 **/
public class topic0809 {
    Set<String> set;
    List<String> list;
    public List<String> generateParenthesis(int n) {
        set = new HashSet<>();
        list = new ArrayList<>();
        dfs("",0,0,n);
        return list;
    }
    public void dfs(String cur,int left,int right,int n){
        if (left == n && right == n){
            if (!set.contains(cur)){
                set.add(cur);
                list.add(cur);
            }
            return;
        }
        //�����Ŵ���������,���Լ�������Ҳ���Լ�������
        if (left < n){
            StringBuilder sb = new StringBuilder(cur);
            //��������
            sb.append('(');
            dfs(sb.toString(),left+1,right,n);
            //��������������������,���Լ�������
            if (left > right){
                StringBuilder sb1 = new StringBuilder(cur);
                sb.append(')');
                dfs(sb1.toString(),left,right+1,n);
            }
        }
    }
}
