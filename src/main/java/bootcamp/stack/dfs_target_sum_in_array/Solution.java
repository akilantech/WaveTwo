package bootcamp.stack.bfs_target_sum_in_array;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S, "");
        return count;
    }

    private void calculate(int[] nums, int growingLength, int runningSum, int targetSum, String log) {
        System.out.println(log);
        if (growingLength == nums.length) {
            if (runningSum == targetSum) {
                count++;
            }
            return;
        }

        calculate(nums, growingLength + 1, runningSum + nums[growingLength], targetSum, String.format("%s + %s", runningSum, nums[growingLength]));
        calculate(nums, growingLength + 1, runningSum - nums[growingLength], targetSum, String.format("%s - %s", runningSum, nums[growingLength]));

    }
}
