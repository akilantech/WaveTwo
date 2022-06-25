package bootcamp.graph.n_array_level_order;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        if(root==null){
            return new ArrayList<>();
        }

        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                tempList.add(current.val);
                List<Node> children = current.children;
                for(Node child : children){
                    queue.add(child);
                }
            }
            result.add(tempList);

        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
