package bootcamp.arrays.maximum_subarray;

public class Solution {

    public static void main(String[] args) {
        int x[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(x));
    }

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int subArraySum = 0;
            for (int j = i ; j < nums.length; j++) {
                subArraySum += nums[j];
                if (subArraySum > maxSum) {
                    maxSum = subArraySum;
                }
            }
        }
        return maxSum;
    }
}
