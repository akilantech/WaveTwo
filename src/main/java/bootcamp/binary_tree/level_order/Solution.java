package bootcamp.binary_tree.level_order;

import bootcamp.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        levelOrder(list, root, 0);

        return list;
    }

    private void levelOrder(List<List<Integer>> levelList, TreeNode node, int level) {
        if (level == levelList.size()) {
            levelList.add(new ArrayList<>());
        }
        List<Integer> integers = levelList.get(level);
        integers.add(node.val);

        if (node.left != null) {
            levelOrder(levelList, node.left, level + 1);
        }

        if (node.right != null) {
            levelOrder(levelList, node.right, level + 1);
        }

    }
}
