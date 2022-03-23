package DailyCode;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê03ÔÂ21ÈÕ 17:42
 **/
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }