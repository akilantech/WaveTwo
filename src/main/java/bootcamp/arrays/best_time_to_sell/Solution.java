package bootcamp.arrays.best_time_to_sell;

public class Solution {

    /*
    *
    * Start with minimum value
    * Start max profit price as zero
    *
    * Condition 1
    * Running value is less than minimum value then swap
    *
    * Condition 2
    * (Running value - minimum) is greater than max profit then swap profit.
    *
    * */
    public static void main(String[] args) {
        int x[] = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println( new Solution().maxProfit(x) );
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if ( prices[i] - minPrice > maxProfit) {
                maxProfit =  prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
