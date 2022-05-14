package bootcamp.graph.disjoint_set;

public class UnionFind {

    private final int[] root;

    public UnionFind(int length) {
        root = new int[length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    int find(int element) {
        return root[element];
    }

    public void union(int x , int y){
        int rootX = root[x];
        int rootY = root[y];

        if(rootX != rootY ){
            for (int i = 0; i < root.length; i++) {
                if(root[i] == rootY){
                    root[i] = rootX;
                }
            }
        }
    }

    boolean connected(int x, int y){
        return root[x] == root[y];
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

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);

        System.out.println(uf.connected(1,5));

        System.out.println(uf);
    }
}
