package bootcamp.graph.disjoint_set;

public class QuickUnion {

    private final int root[];

    public QuickUnion(int length) {
        this.root = new int[length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }


}
