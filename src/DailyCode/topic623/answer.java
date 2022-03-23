package DailyCode.topic623;

import java.util.LinkedList;

public class answer {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root==null || depth==1){
            TreeNode node = new TreeNode(val);
            node.left=root;
            return node;
        }
        int deep = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            deep++;
            int n=queue.size();
            for (int i=0;i<n;i++){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                if (node.left!=null) {
                    queue.add(node.left);
                    if (deep==depth-1){
                        TreeNode left = new TreeNode(val);
                        left.left=node.left;
                        node.left=left;
                        TreeNode right = new TreeNode(val);
                        right.right=node.right;
                        node.right=right;
                        node.left=left;
                    }
                }
                if (node.right!=null) {
                    queue.add(node.right);
                    if (deep==depth-1){
                        TreeNode left = new TreeNode(val);
                        left.left=node.left;
                        node.left=left;
                        TreeNode right = new TreeNode(val);
                        right.right=node.right;
                        node.right=right;
                        node.right=right;
                    }
                }

            }
        }
        if (depth>deep){
                deep=0;
                queue.add(root);
                while (!queue.isEmpty()){
                    deep++;
                    int n=queue.size();
                    for (int i=0;i<n;i++){
                        TreeNode node = queue.getFirst();
                        queue.removeFirst();
                        if (node.left!=null) {
                            queue.add(node.left);
                        }
                        if (node.right!=null) {
                            queue.add(node.right);
                        }
                        if (deep==depth-1){
                            TreeNode left = new TreeNode(val);
                            left.left=node.left;
                            node.left=left;
                            TreeNode right = new TreeNode(val);
                            right.right=node.right;
                            node.right=right;
                        }
                    }
                }
        }
        return root;
    }
}
