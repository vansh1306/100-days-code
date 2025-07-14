class Solution {
    public int searchInsert(int[] nums, int target) {
        // Initialize the left and right pointers. 
        // Right is initially set to the length of the array rather than the last index.
        int left = 0, right = nums.length;
      
        // Binary search to find the target or the insertion point.
        while (left < right) {
            // Calculate the middle index. 
            // Use unsigned right shift to avoid potential overflow for large left/right.
            int mid = (left + right) >>> 1;
          
            // If the current element at the middle index is greater than or equal to the target,
            // narrow the search to the left half (inclusive of mid).
            if (nums[mid] >= target) {
                right = mid;
            } else {
                // Otherwise, narrow the search to the right half (exclusive of mid).
                left = mid + 1;
            }
        }
        // Since the algorithm is looking for the insertion point, left will be the correct index
        // whether the target is found or not.
        return left;
    }
}