package bootcamp.binary_tree.check_subtree;

import bootcamp.binary_tree.TreeNode;

public class Solution {


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean sameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        return tree1 != null && tree2 != null && tree1.val == tree2.val && sameTree(tree1.left,tree2.left) && sameTree(tree1.right,tree2.right);

    }

}
