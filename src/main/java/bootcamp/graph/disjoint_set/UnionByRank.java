package bootcamp.graph.disjoint_set;

public class UnionByRank {

    final int root[];
    final int rank[];

    public UnionByRank(int length) {
        root = new int[length];
        rank = new int[length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        while (root[x] != x) {
            x = root[x]; // Go to the root.
        }
        return x;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY){
            return;
        }
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }else if(rank[rootY] > rank[rootX]){
            root[rootX] = rootY;
        }else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }

    boolean connected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionByRank uf = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        System.out.println(uf);
        uf.union(1, 2);
        System.out.println(uf);
        uf.union(2, 5);
        System.out.println(uf);
        uf.union(5, 6);
        System.out.println(uf);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "root=" + ToString(root) +
                '}';
    }

    private String ToString(int[] root) {
        StringBuffer result = new StringBuffer("\n");
        for (int i = 0; i < root.length; i++) {
            result.append(i);
            result.append(",");
        }
        result.append("\n");
        for (int i = 0; i < root.length; i++) {
            result.append(root[i]);
            result.append(",");
        }
        return result.toString();

    }
}
