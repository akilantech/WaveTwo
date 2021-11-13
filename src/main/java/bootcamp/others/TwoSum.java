package bootcamp.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int x[] = new int[]{2,7,11,15};

        Arrays.stream(new TwoSum().twoSum(x,9)).forEach(value -> System.out.println(value));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(pair,i);
            }
        }
        return new int[]{};
    }


}
