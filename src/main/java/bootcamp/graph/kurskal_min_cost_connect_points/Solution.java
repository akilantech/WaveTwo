package bootcamp.graph.kurskal_min_cost_connect_points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Given().minCostConnectPoints(new int[][]{{-8,14},{16,-18},{-19,-13},{-18,19},{20,20},{13,-20},{-15,9},{-4,-8}}));
    }

    public int minCostConnectPoints(int[][] points) {

        List<int[]> weightedEdges = new ArrayList<>();

        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);
                weightedEdges.add(new int[]{weight, i, j});
            }
        }
        weightedEdges.sort(Comparator.comparingInt(o -> o[0]));

        int edgeCount = 0;
        int maxWeight = 0;
        UnionFind uf = new UnionFind(points.length);
        for (int i = 0; i < weightedEdges.size() && edgeCount < points.length - 1; i++) {

            int weight = weightedEdges.get(i)[0];
            int x = weightedEdges.get(i)[1];
            int y = weightedEdges.get(i)[2];

            if (uf.union(x, y)) {
                maxWeight += weight;
                edgeCount++;
            }
        }

        return maxWeight;
    }

    private static class UnionFind {

        final private int[] root;
        final private int[] rank;

        public UnionFind(int length) {
            root = new int[length];
            rank = new int[length];

            for (int i = 0; i < length; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            while (root[x] != x) {
                x = root[x];
            }
            return x;
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootY] += 1;
            }
            return true;
        }
    }
}
