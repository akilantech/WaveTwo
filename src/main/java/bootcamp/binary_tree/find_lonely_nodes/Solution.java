package bootcamp.binary_tree.find_lonely_nodes;

import bootcamp.binary_tree.TreeNode;
import bootcamp.binary_tree.Util;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        new Solution().getLonelyNodes(Util.arrayToTree(new Integer[]{11,99,88,77,null,null,66,55,null,null,44,33,null,null,22})).stream().forEach(System.out::println);
    }

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findLonelyNodes(root, list);
        return list;

    }

    private TreeNode findLonelyNodes(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        TreeNode left = findLonelyNodes(root.left, list);
        TreeNode right = findLonelyNodes(root.right, list);

        if (left == null && right == null) {
            return root;
        }

          if (left != null && right != null) {
            return root;
        }
       // System.out.println("Current Val:"+root.val);

        if(left !=null) {
         //   System.out.println("Left Val:"+root.left.val);
            list.add(root.left.val);
        }

        if(right !=null) {
           // System.out.println("Right Val:"+root.right.val);
            list.add(root.right.val);
        }
        return root;
    }
}
