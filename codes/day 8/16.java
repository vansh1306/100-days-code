class Solution {
    public int rearrangeCharacters(String s, String target) {
        // counts for characters in 's'
        int[] countS = new int[26];
        // counts for characters in 'target'
        int[] countTarget = new int[26];

        // Count frequency of each character in 's'
        for (int i = 0; i < s.length(); ++i) {
            countS[s.charAt(i) - 'a']++;
        }

        // Count frequency of each character in 'target'
        for (int i = 0; i < target.length(); ++i) {
            countTarget[target.charAt(i) - 'a']++;
        }

        // Initialize the answer with a high value.
        // It represents the maximum number of times 'target' can be formed.
        int maxFormable = Integer.MAX_VALUE;

        // Calculate the number of times 'target' can be formed
        for (int i = 0; i < 26; ++i) {
            if (countTarget[i] > 0) {
                // Find the minimum number of times a character from 'target'
                // can be used based on its frequency in 's'
                maxFormable = Math.min(maxFormable, countS[i] / countTarget[i]);
            }
        }

        // Return the maximum number of times 'target' can be formed
        return maxFormable;
    }
}