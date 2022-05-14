package bootcamp.graph.bfs_all_paths.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int input[][] = new int[][]{
                {4, 3, 1}, {3, 2, 4}, {3}, {4}, {}
        };

        new Solution().allPathsSourceTarget(input);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph==null  || graph.length == 0) return null;

        List<List<Integer>> paths = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> seed = new ArrayList<>();
        seed.add(0);
        queue.add(seed);

        while (!queue.isEmpty()){
            List<Integer> current = queue.poll();
            Integer node =  current.get(current.size() - 1); // find last value

            for(int neighbour : graph[node]){
                List<Integer> tempPath = new ArrayList<>(current);
                int lastNode = graph.length-1;
                tempPath.add(neighbour);
                print(tempPath);
                if(neighbour == lastNode){
                    paths.add(tempPath);
                }else{
                    queue.add(tempPath);
                }
            }
        }
        return paths;
    }

    private void print(List<Integer> tmpPath) {
        tmpPath.stream().forEach(integer -> System.out.print(integer+","));
        System.out.println();
    }
}
