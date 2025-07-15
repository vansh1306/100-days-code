class Solution {
  
    /**
     * Finds all the elements of [1, n] inclusive that do not appear in the array.
     *
     * @param nums Array of integers ranging from 1 to n, possibly containing duplicates.
     * @return A list of integers that are missing from the array.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // Iterate over each number in the array.
        for (int num : nums) {
            // Use absolute value in case nums[i] has been marked negative already.
            int index = Math.abs(num) - 1;
          
            // Mark the number at index i as negative if it's not already.
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Create a list to hold the result of missing numbers.
        List<Integer> missingNumbers = new ArrayList<>();

        // Check for numbers that were not marked negative.
        for (int i = 0; i < n; i++) {
            // If the number is positive, the number (i + 1) is missing.
            if (nums[i] > 0) {
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }
}
