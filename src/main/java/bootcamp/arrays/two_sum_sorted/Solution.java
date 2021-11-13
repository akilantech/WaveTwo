package bootcamp.arrays.two_sum_sorted;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        //[2,7,11,15], target = 9

      Arrays.stream(new Solution().twoSum(new int[]{2,7,11,15},9)).forEach(System.out::println);

    }

    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length - 1;
        while (begin >= 0 && end <= numbers.length) {

            int low = numbers[begin];
            int hi = numbers[end];

            if (low + hi == target) {
                return new int[]{begin + 1, end + 1}; //zero indexed array
            } else if (low + hi < target) {
                begin++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};

    }


}
