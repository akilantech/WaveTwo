package bootcamp.disjoint_set.earlies_moment_everyone_friends;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {


    }

    public int earliestAcq(int[][] logs, int n) {

        if(logs.length < n-1 )
            return -1;

        List<int[]> list = Arrays.asList(logs);
        list.sort(Comparator.comparingInt(o -> o[0]));

        int expectedCountToAcc = n - 1;
        QuickUnion qf = new QuickUnion(n);
        for (int i = 0; i < logs.length; i++) {
            int x = list.get(i)[1];
            int y = list.get(i)[2];
            if(qf.union(x, y)){
                expectedCountToAcc--;
            }

            if(expectedCountToAcc == 0){
                return list.get(i)[0];
            }
        }

        return -1;

    }

    static class QuickUnion {

        final int root[];

        QuickUnion(int rootLength) {
            this.root = new int[rootLength];
            for (int i = 0; i < rootLength; i++) {
                root[i] = i;
            }
        }

        int find( int x){
            if(this.root[x] == x){
                return x;
            }
            return find(root[x]);
        }

        boolean union(int x, int y){
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
