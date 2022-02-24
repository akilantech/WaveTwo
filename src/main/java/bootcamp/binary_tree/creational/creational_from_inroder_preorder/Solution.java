package bootcamp.binary_tree.creational_from_inroder_preorder;

import bootcamp.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = getInorderElementIndexMap(inorder);
        return buildTree(preorder, inOrderMap, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderIndexMap, int left, int right) {
        if (left > right) {
            return null;
        }

        int currValue = preorder[preOrderIndex++];
        System.out.println(currValue);
        TreeNode node = new TreeNode(currValue);
        node.left = buildTree(preorder, inorderIndexMap, 0, inorderIndexMap.get(currValue) - 1);
        node.right = buildTree(preorder, inorderIndexMap, inorderIndexMap.get(currValue) + 1, right);
        return node;

    }

    private Map<Integer, Integer> getInorderElementIndexMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }


}
