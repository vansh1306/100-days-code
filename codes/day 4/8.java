class Solution {

    // Method to find the relative ranks for athletes based on their scores.
    public String[] findRelativeRanks(int[] scores) {
        // Get the number of athletes based on the length of scores array.
        int numAthletes = scores.length;
      
        // Create a wrapper array to hold the indices of the scores. 
        Integer[] indices = new Integer[numAthletes];
      
        // Initialize the indices array with values from 0 to numAthletes-1.
        for (int i = 0; i < numAthletes; ++i) {
            indices[i] = i;
        }
      
        // Sort the indices array based on the scores in descending order. 
        // The comparison function uses the scores at the indices to sort the indices.
        Arrays.sort(indices, (a, b) -> Integer.compare(scores[b], scores[a]));
      
        // Create an array to hold the answers (relative ranks as strings).
        String[] ranks = new String[numAthletes];
      
        // Create an array to hold the medals for the top 3 athletes.
        String[] medals = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
      
        // Assign the appropriate rank to each athlete in the ranks array.
        for (int i = 0; i < numAthletes; ++i) {
            // If the rank is within the top 3, assign the corresponding medal.
            if (i < 3) {
                ranks[indices[i]] = medals[i];
            } else {
                // Otherwise, assign the rank number as a string (1-indexed).
                ranks[indices[i]] = String.valueOf(i + 1);
            }
        }
      
        // Return the array of ranks.
        return ranks;
    }
}