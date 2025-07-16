class Solution {
    // Method to find total time for which a character remains poisoned
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // Length of the timeSeries array
        int n = timeSeries.length;
      
        // If there are no attacks, return 0 as the poisoned duration
        if (n == 0) {
            return 0;
        }
      
        // Initialize total poisoned duration with the duration of the first attack
        int totalPoisonedDuration = duration;
      
        // Iterate through the time series starting from the second attack
        for (int i = 1; i < n; ++i) {
            // Calculate the time difference between current and previous attack
            int timeDifference = timeSeries[i] - timeSeries[i - 1];
          
            // If the time difference is less than the duration of the poison,
            // it means the poison effect would have been refreshed and not lasted full duration,
            // so add the time difference, otherwise add the full duration
            totalPoisonedDuration += Math.min(duration, timeDifference);
        }
      
        // Return the total duration for which the character was poisoned
        return totalPoisonedDuration;
    }
}
