package bootcamp.arrays.next_warm_temp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonicStack {

    public static void main(String[] args) {
        Arrays.stream(new Solution().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})).forEach(System.out::print);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int currDayTemp = temperatures[currDay];

            while (!stack.isEmpty() && temperatures[stack.peek()] < currDayTemp) {
                int prevDay = stack.pop();
                result[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);

        }
        return result;
    }
}
