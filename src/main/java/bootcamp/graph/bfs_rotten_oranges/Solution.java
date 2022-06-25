package bootcamp.graph.bfs_rotten_oranges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[][] input = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        new Solution().orangesRotting(input);
    }

    final int[][] DIRECTIONS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int totalFresh = 0;
        int totalMin = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    totalFresh++;
                }
            }
        }

        while (!queue.isEmpty() && totalFresh > 0) {
            totalMin++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] neighbour : getNeighbours(current, grid)) {
                    grid[neighbour[0]][neighbour[1]] = 2;
                    queue.add(new int[]{neighbour[0], neighbour[1]});
                    totalFresh--;
                }

            }
        }

        if (totalFresh > 0) {
            return -1;
        } else {
            return totalMin;
        }

    }

    private List<int[]> getNeighbours(int[] current, int[][] grid) {
        List<int[]> list = new ArrayList<>();
        for (int[] direction : DIRECTIONS) {
            int newRow = current[0] + direction[0];
            int newCol = current[1] + direction[1];
            if (newRow < 0
                    || newRow >= grid.length
                    || newCol < 0 
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] == 0
                    || grid[newRow][newCol] == 2
            ) {
                continue;
            }
            list.add(new int[]{newRow, newCol});
        }
        return list;
    }

}
