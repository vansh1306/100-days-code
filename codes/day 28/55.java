class Solution {
    // Function to determine if the array is either entirely non-increasing or non-decreasing
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true; // To keep track if the array is non-decreasing
        boolean isDecreasing = true; // To keep track if the array is non-increasing
      
        // Iterate over the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                // If the current number is less than the previous, it's not non-decreasing
                isIncreasing = false;
            }
            if (nums[i] > nums[i - 1]) {
                // If the current number is greater than the previous, it's not non-increasing
                isDecreasing = false;
            }
            // If the array is neither non-decreasing nor non-increasing, return false
            if (!isIncreasing && !isDecreasing) {
                return false;
            }
        }
        // If we reach this point, the array is either non-decreasing, non-increasing, or all elements are equal
        return true;
    }
}