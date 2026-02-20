public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        // Keep track of left and right pointers
        // Left pointer is buying day, right pointer is selling day
        int l = 0, r = 1;
        // Keep track of max profit
        int maxProfit = 0;

        while (r < prices.length) {
            // If the buying day price is lss than the selling day price, then we can make a profit
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            // Else move the left pointer to the right, so we can buy at a lower price
            } else {
                l = r;
            }
            // Move right pointer to check for next selling day
            r++;
        }
        return maxProfit;
    }
}