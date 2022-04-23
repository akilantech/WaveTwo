package bootcamp.binary_tree.from_inorder_preorder;

import bootcamp.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Integer, Integer> inorderIndex = new HashMap<>();
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return arrayToBinaryTree(preorder,0, preorder.length-1);
    }

    private TreeNode arrayToBinaryTree(int[] preorder, int left, int right) {

        if( left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        root.left = arrayToBinaryTree(preorder,left,inorderIndex.get(root.val)-1);
        root.right = arrayToBinaryTree(preorder, inorderIndex.get(root.val)+1,right);

        return root;

    }
}
