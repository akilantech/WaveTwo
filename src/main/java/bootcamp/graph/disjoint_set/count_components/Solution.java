package bootcamp.disjoint_set.count_components;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for(int edge[] : edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.countRoot();
    }

    static class UnionFind{
        final int root[];
        public UnionFind(int length) {
            this.root = new int[length];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
        }

        int find(int x){
            while (root[x] != x){
                x = root[x];
            }
            return x;
        }

        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
               root[rootY] = rootX;
            }
        }

        int countRoot(){
            int count = 0;
            for (int i = 0; i < root.length; i++) {
                if(root[i] == i){
                    count++;
                }
            }
            return count;
        }
    }
}
