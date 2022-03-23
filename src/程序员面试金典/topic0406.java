package 程序员面试金典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月08日 11:27
 **/
public class topic0406 {
    List<TreeNode> list = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        for (int i=0;i<list.size();i++){
            if (list.get(i) == p && i != list.size()-1){
                return list.get(i+1);
            }
        }
        return null;
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            dfs(root.left);
        }
        list.add(root);
        if (root.right != null){
            dfs(root.right);
        }
    }
}
