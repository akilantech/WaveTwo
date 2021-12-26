package bootcamp.binary_search.basic;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().binarySearch(new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10}, 2));
    }


    int binarySearch(int[] num, int target) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = -1;
        int result = -1;
        int ans = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            result = num[mid];

            System.out.printf("lo: %s hi: %s mid: %s result: %s%n", lo, hi, mid, result);

            if (target > result) {
                ans = result;
                lo = mid + 1;
            } else if (target < result) {
                hi = mid - 1;
            } else {
                return result;
            }
        }
        return ans;
    }


}
