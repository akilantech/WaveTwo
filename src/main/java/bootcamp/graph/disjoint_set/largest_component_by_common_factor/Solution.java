package bootcamp.disjoint_set.largest_component_by_common_factor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = new Solution().largestComponentSize(nums);
        System.out.println(i);
    }

    public int largestComponentSize(int[] nums) {
        int reduce = Arrays.stream(nums).reduce(nums[0], Math::max);
        System.out.println("Max:" + reduce);
        UnionFind uf = new UnionFind(reduce);

        for (int i = 0; i < nums.length; i++) {

            for (int j = 2; j < Math.sqrt(nums[i]) + 1; ++j) {
                System.out.println("factor " + j + " working on " + nums[i]);

                if (nums[i] != j && nums[i] % j == 0) {

                    uf.union(nums[i], j);
                    uf.union(nums[i], nums[i] / j);
                }

                uf.print();
            }

        }

        Map<Integer, Integer> groupCountMap = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int groupId = uf.find(nums[i]);
            int count = groupCountMap.getOrDefault(groupId, 0);
            groupCountMap.put(groupId, count + 1);
            maxCount = Math.max(maxCount, count + 1);
        }

        uf.print();
        return maxCount;
    }

    static class UnionFind {

        int root[];
        int rank[];

        public UnionFind(int length) {
            root = new int[length + 1];
            rank = new int[length + 1];
            for (int i = 0; i < length + 1; i++) {
                root[i] = i;
                rank[i] = 1;
            }
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
                if(rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                }else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }

            }
        }

        void print() {
            IntStream range = IntStream.range(0, root.length);
            range.forEach(value -> System.out.println(value + ":" + root[value]));
        }
    }
}
