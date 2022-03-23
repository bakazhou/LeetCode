package 程序员面试金典;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 13:49
 **/
public class topic0409 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //说明t2已经遍历完
        if (t2 == null){
            return true;
        }
        //t1已经遍历完而 t2未遍历完
        if (t1 == null){
            return false;
        }
        //当前值相同 开始检查是否为子树
        if (t1.val == t2.val){
            return checkSubTree(t1.left,t2.left) || checkSubTree(t2.right,t2.right);
        }else {
            //当前值不同
            return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
        }
    }
}
