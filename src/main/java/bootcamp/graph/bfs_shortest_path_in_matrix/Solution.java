package bootcamp.graph.bfs_shortest_path_in_matrix;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
       System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{0}}));
    }

    int[][] DIRECTIONS = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1},
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0] == 0) {
            queue.add(new int[]{0, 0});
            grid[0][0] = 1;
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = grid[row][col];
            if(row == grid.length - 1 && col == grid[0].length-1){
                return distance;
            }
            for (int[] neighbour : getNonZeroNeighbours(current, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow,neighbourCol});
                grid[neighbourRow][neighbourCol] = distance+1;
            }
        }
         return -1;
    }

    List<int[]> getNonZeroNeighbours(int[] x, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int[] direction : DIRECTIONS) {
            int newRow = x[0] + direction[0];
            int newCol = x[1] + direction[1];
            if (newRow < 0 || newRow > grid.length - 1) {
                continue;
            }
            if (newCol < 0 || newCol > grid[0].length - 1) {
                continue;
            }
            int value = grid[newRow][newCol];
            if (value == 0) {
                neighbours.add(new int[]{newRow, newCol});
            }
        }
        System.out.print("["+x[0]+"]["+x[1]+"]---------->");
        neighbours.forEach(ints -> System.out.print("["+ints[0]+"]["+ints[1]+"],    "));
        System.out.println();
        return neighbours;
    }


}
