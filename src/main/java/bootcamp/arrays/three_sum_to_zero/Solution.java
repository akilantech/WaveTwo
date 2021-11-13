package bootcamp.arrays.three_sum_to_zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

/*
*  Try to understand two sum II
*  Remove duplicates by checking  n != n-1 in while loop.
*
*  If target is zero, only negative and positive will make zero
*
*  zero can be matched with other zero. line number 32. equalizing pivot with zero.
*
*
* */


    public static void main(String[] args) {
        new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(integers -> {
            System.out.println(integers);
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(i, nums, result);
            }
        }
        return result;
    }

    private void twoSum(int i, int[] num, List<List<Integer>> result) {
        int low = i + 1;
        int hi = num.length - 1;

        while (low < hi) {
            System.out.println(num[i]);
            int sum = num[i] + num[low] + num[hi];
            if (0 < sum) {
                hi--;
            } else if (0 > sum) {
                low++;
            } else {
                result.add(Arrays.asList(num[i], num[low++], num[hi--]));
                while ( low<hi && num[low - 1] == num[low]) {
                    low++;
                }
            }
        }
    }
}
