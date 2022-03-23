package ����Ա���Խ��;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��13�� 13:46
 **/
public class topic0405 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidBST1(TreeNode root,int max,int min) {
        if (root == null){
            return true;
        }
        if (root.val > max){
            max = root.val;
        }
        if (root.val < min){
            min = root.val;
        }
        if (root.val > max){
            return false;
        }
        if (root.val < min){
            return false;
        }
        //���С�ڸ��ڵ� �ұߴ��ڸ��ڵ�
        if (root.left != null){
            if (root.left.val >= root.val){
                return false;
            }
        }
        if (root.right != null){
            if (root.right.val <= root.val){
                return false;
            }
        }
        return isValidBST1(root.left,max,min) && isValidBST1(root.right,max,min);
    }
}
