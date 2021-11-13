package bootcamp.arrays.single_number_in_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {
        Arrays.stream(new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5})).forEach(value -> System.out.println(value));
    }

    public int[] singleNumber(int[] nums) {

        HashMap<Integer, Integer> occurance = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (occurance.containsKey(nums[i])) {
                occurance.put(nums[i], occurance.get(nums[i]) + 1);
            } else {
                occurance.put(nums[i], 1);
            }
        }
        int result[] = new int[2];
        int resultPointer = 0;
        for (int i = 0; i < nums.length; i++) {

            if (occurance.get(nums[i]) == 1) {
                result[resultPointer++] = nums[i];
            }
        }
        return result;
    }
}
