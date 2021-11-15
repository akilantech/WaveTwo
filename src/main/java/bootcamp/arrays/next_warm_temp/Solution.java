package bootcamp.arrays.next_warm_temp;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Arrays.stream(new Solution().dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78})).forEach(System.out::print);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            int j = i+1;
            int warmDayAheadCount = 0;
            while (j < temperatures.length - 1 && temperatures[i] >= temperatures[j] ) {
                j++;
                warmDayAheadCount++;
            }
            if(temperatures[i] < temperatures[j]){
                warmDayAheadCount++;
                result[i] = warmDayAheadCount;
            }else{
                result[i] = 0;
            }

        }
        return result;
    }

}
