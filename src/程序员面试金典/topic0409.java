package ����Ա���Խ��;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��09�� 13:49
 **/
public class topic0409 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //˵��t2�Ѿ�������
        if (t2 == null){
            return true;
        }
        //t1�Ѿ�������� t2δ������
        if (t1 == null){
            return false;
        }
        //��ǰֵ��ͬ ��ʼ����Ƿ�Ϊ����
        if (t1.val == t2.val){
            return checkSubTree(t1.left,t2.left) || checkSubTree(t2.right,t2.right);
        }else {
            //��ǰֵ��ͬ
            return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
        }
    }
}
