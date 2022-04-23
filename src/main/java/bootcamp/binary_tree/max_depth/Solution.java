package bootcamp.binary_tree.max_depth;

import bootcamp.binary_tree.TreeNode;

public class Solution {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }

    }



}
