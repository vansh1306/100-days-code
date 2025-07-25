class Solution {
    public int scoreOfString(String s) {
        int score = 0; // Initialize the score to zero
      
        // Iterate over the string starting from the second character
        for (int i = 1; i < s.length(); ++i) {
            // Calculate the absolute difference in ASCII values between consecutive characters and add to the score
            score += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }
      
        return score; // Return the final score
    }
}