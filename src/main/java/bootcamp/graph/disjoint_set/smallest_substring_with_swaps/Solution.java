package bootcamp.graph.disjoint_set.smallest_substring_with_swaps;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        UnionFind uf = new UnionFind(s.length());
        for (int i = 0; i < pairs.size(); i++) {
            List<Integer> pair = pairs.get(i);
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> group = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            List<Integer> values = group.getOrDefault(root, new ArrayList<>());
            values.add(i);
            group.putIfAbsent(root, values);
        }

        char[] smallestString = new char[s.length()];

        for (List<Integer> value : group.values()) {
            char[] subset = new char[value.size()];
            for (int v = 0; v < value.size(); v++) {
                subset[v] = s.charAt(value.get(v));
            }
            Arrays.sort(subset);

            for (int i = 0; i < value.size(); i++) {
                smallestString[value.get(i)] = subset[i];
            }
        }

        return new String(smallestString);
    }

    static class UnionFind {

        int root[];
        int rank[];

        public UnionFind(int length) {
            this.root = new int[length];
            this.rank = new int[length];
            IntStream range = IntStream.range(0, length);
            range.forEach(index -> root[index] = index);
            range.forEach(index -> rank[index] = 1);
        }

        int find(int x) {
            while (root[x] != x) {
                x = root[x];
            }
            return x;
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                }else{
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }

        }
    }
}
