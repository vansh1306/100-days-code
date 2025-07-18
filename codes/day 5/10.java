class Solution {
    // Method to concatenate the array with itself
    public int[] getConcatenation(int[] nums) {
        // Get the length of the input array
        int n = nums.length;
        // Create a new array that is twice the length of the input array
        int[] result = new int[n * 2];
        // Loop through the new array to fill it with elements from the input array
        for (int i = 0; i < n * 2; ++i) {
            // Since we are concatenating the input array with itself,
            // we use the modulo operator to wrap around the index for array 'nums'
            // This is because 'nums' has a length of 'n' and 'result' has a length of 'n * 2'
            // Therefore, when 'i' is greater than or equal to 'n', 
            // 'i % n' will start from 0 again, essentially repeating the array 'nums'
            result[i] = nums[i % n];
        }
        // Return the concatenated array
        return result;
    }
}