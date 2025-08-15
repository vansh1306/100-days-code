class Solution {
    public int maxProfit(int[] prices) {
        // Step 1: Initialize variables
        int min = prices[0];   // Minimum price seen so far (buy price)
        int max = prices[0];   // Current selling price candidate
        int ans = max - min;   // Maximum profit so far

        // Step 2: Iterate through prices
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                // Found a new lower price → update min (buy cheaper)
                min = prices[i];
            }
            else{
                // Treat as a possible sell → calculate profit
                max = prices[i];
                if(ans < max - min)
                    ans = max - min; // Update if better profit found
            }
        }

        // Step 3: Return the result
        return ans;
    }
}