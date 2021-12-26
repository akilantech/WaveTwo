package bootcamp.heap.max_product_in_array;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().maxProduct(new int[]{3, 4, 5, 2}));
    }

    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

}
