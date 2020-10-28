/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
  If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class Stocks {

    /**
     * Dynamic programming solution O(n): keep track of the lowest buying point and highest selling point
     * update the max profit if the curr profit is bigger than the max profit
     * update the buy point if next price is lower than the current buy point. Reset the sell point as well, since sell has to come after the buy
     * update the sell point if next price is higher than the current sell point
     *
     * @param prices list of prices for each day
     * @return return the max profit. Sell day must be after the buy day
     */
    public int maxProfit(int[] prices) {

        //trivial cases
        if (prices.length <= 1) return 0;
        if (prices.length == 2) {
            if(prices[1] - prices[0] > 0) {
                return prices[1] - prices[0];
            } else {
                return 0;
            }
        }
        //set buy to the first date and sell to the second date. If the profit is positive, set profit to sell-buy, 0 otherwise
        int buy = prices[0];
        int sell = prices[1];
        int profit = 0;
        if (sell - buy > 0) profit = sell-buy;

        //loop through the array and update buy and sell prices according do the guidelines described at the method explanation
        for (int x = 0; x < prices.length; x++) {
            if (prices[x] < buy) {
                buy = prices[x];
                sell = prices[x];
            } else {
                sell = prices[x];
            }
            if(profit < sell-buy) {
                profit = sell-buy;
            }
        }
        return profit;
    }

}
