package DailyCode.topic563;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
        int ans = 0;
        public int findTilt(TreeNode root) {
            if (root!=null){
                dfs(root);
            }
            return ans;
        }
        public int dfs(TreeNode node){
            int left = 0;
            if (node.left!=null){
                left += dfs(node.left);
            }
            int right = 0;
            if (node.right!=null){
                right += dfs(node.right);
            }
            ans+=Math.abs(left-right);
            return left+right+node.val;
        }
}