package bootcamp.graph.disjoint_set.grap_valid_tree;

public class Solution {

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},{2,1},{2,0},{2,4}
        };

        System.out.println(new Solution().validTree(5,edges));
    }


    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1){
            return false;
        }

        QuickUnion quickUnion = new QuickUnion(n);
            for (int edge[] : edges){
                int edgeA = edge[0];
                int edgeB = edge[1];

                if( !quickUnion.union(edgeA,edgeB)){
                    return false;
                }
            }

            return true;

    }


    static class QuickUnion {

        private final int root[];

        public QuickUnion(int length) {
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

        boolean  union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY){
                return false;
            }
            root[rootY] = rootX;
            return true;
        }

    }


}
