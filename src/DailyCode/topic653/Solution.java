package DailyCode.topic653;

import DailyCode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bakazhou
 * @description
 * @date 2022Äê03ÔÂ21ÈÕ 17:42
 **/
class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        if (set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}