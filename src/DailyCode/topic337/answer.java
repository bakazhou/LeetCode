package DailyCode.topic337;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
    }
}
public class answer {
    public static class Info{
        public int stellValue;
        public int noStellValue;
        public Info(int n,int m){
            this.stellValue=n;
            this.noStellValue=m;
        }
    }
    public Info judge(TreeNode root) {
        if (root==null){//节点为空,不继续向下递归
            return null;
        }
        int stell = root.val;
        int noStell = 0;
        if (root.left!=null){
            Info info = judge(root.left);
            stell += info.noStellValue;//这层不能偷
            noStell += Math.max(info.stellValue,info.noStellValue);//可以偷也可以不偷
        }
        if (root.right!=null){
            Info info = judge(root.right);
            stell += info.noStellValue;//这层不能偷
            noStell += Math.max(info.stellValue,info.noStellValue);//可以偷也可以不偷
        }
        return new Info(stell,noStell);
    }
    public int rob(TreeNode root) {
        Info info = judge(root);
        return Math.max(info.stellValue,info.noStellValue);
    }
}
