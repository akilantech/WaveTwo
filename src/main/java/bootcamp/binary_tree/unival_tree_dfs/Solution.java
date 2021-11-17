package bootcamp.binary_tree.unival_tree_dfs;

import bootcamp.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {




    public boolean isUnivalTree(TreeNode root) {

        List<Integer> values = new ArrayList<>();
        dfs(root,values);
        for (Integer val:values ) {
            if(!values.get(0).equals(val)){
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> values) {
        if(root == null){
            return;
        }
        values.add(root.val);
        dfs(root.left,values);
        dfs(root.right,values);
    }
}
