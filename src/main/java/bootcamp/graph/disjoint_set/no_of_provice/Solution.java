package bootcamp.graph.disjoint_set.no_of_provice;

import java.util.Arrays;

public class Solution {

    public int findCircleNum(int[][] input) {
        int parent[] = new int[input.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 1) {
                    union(parent, i, j);
                }

            }
        }
        long count = Arrays.stream(parent).filter(value -> value == -1).count();
        return (int) count;
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    private int find(int[] parent, int x) {

        while (parent[x] != -1){
            x = parent[x];
        }
        return x;
    }


}
