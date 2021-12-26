package bootcamp.binary_search_tree.is_valid_bst;

import bootcamp.binary_tree.TreeNode;

public class Solution {

    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);

    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && prev >= root.val) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}
