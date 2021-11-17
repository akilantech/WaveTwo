package bootcamp.binary_tree;

public class Util {

    public static TreeNode arrayToTree(Integer[] input) {
        TreeNode root = createTreeNode(input, 1);
        return root;
    }

    public static TreeNode createTreeNode(Integer[] input, int index) {
        if (index <= input.length) {
            Integer value = input[index - 1];
            if (value != null) {
                TreeNode t = new TreeNode(value);
                t.left = createTreeNode(input, index * 2);
                t.right = createTreeNode(input, index * 2 + 1);
                return t;
            }
        }
        return null;
    }
}
