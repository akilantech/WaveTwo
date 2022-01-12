package bootcamp.stack.warmer_temprature;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Arrays.stream(new Solution().dailyTemperatures(new int[]{71,74,69,70,71,76})).forEach(System.out::println);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answers = new int[temperatures.length];
        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currentDay]) {
                int prevDay = stack.pop();
                answers[prevDay] = currentDay - prevDay;
            }
            stack.push(currentDay);
        }
        return answers;
    }
}
