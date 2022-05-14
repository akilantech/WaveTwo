package bootcamp.disjoint_set.is_valid_path_exists_dfs;

import java.util.*;

public class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        boolean visited[] = new boolean[n];
        Arrays.fill(visited,false);

        for (int edge[] : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(source);
        while (!stack.isEmpty()){

            Integer current = stack.pop();
            if(current == source){
                return true;
            }

            if(visited[current]){
                continue;
            }
            visited[current]=true;

            List<Integer> neighbours = adjacencyList.get(current);
            for (int i = 0; i < neighbours.size(); i++) {
                Integer adjacent = neighbours.get(i);
                visited[adjacent] = true;
                stack.push(adjacent);
            }
        }
        return false;

    }
}
