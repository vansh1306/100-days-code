class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int profit = 0,mini = nums[0];

        for(int i=1;i<n;i++){
            int val = nums[i]-mini;
            profit = Math.max(profit,val);
            dp1[i] = profit;
            mini = Math.min(mini,nums[i]);
        }

        profit = 0;
        int maxi = nums[n-1],max_profit = 0;

        for(int i=n-2;i>=0;i--){
            int val = maxi-nums[i];
            profit = Math.max(profit,val);
            max_profit = Math.max(max_profit,dp1[i]+profit);
            maxi = Math.max(maxi,nums[i]);
        }

        return max_profit;       
    }
}