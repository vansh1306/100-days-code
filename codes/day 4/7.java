class Solution {

    // Function to find the words that can be typed using letters of one row on the keyboard
    public String[] findWords(String[] words) {
        // String representing rows of the keyboard as numbers (1st row, 2nd row, 3rd row)
        // a, b, c, etc. are mapped to their respective row numbers
        String rowMapping = "12210111011122000010020202";
        // List to store the eligible words
        List<String> result = new ArrayList<>();

        // Iterate over the array of words
        for (String word : words) {
            // Convert the word to lower case to make it case-insensitive
            String lowerCaseWord = word.toLowerCase();
            // Get the row number of the first character
            char initialRow = rowMapping.charAt(lowerCaseWord.charAt(0) - 'a');
            // Flag to check if all letters are in the same row
            boolean canBeTyped = true;

            // Iterate over characters of the word
            for (char character : lowerCaseWord.toCharArray()) {
                // Check if character is in a different row
                if (rowMapping.charAt(character - 'a') != initialRow) {
                    canBeTyped = false;
                    break; // No need to check further if one letter is in a different row
                }
            }

            // If all characters are in the same row, add the original word to the result
            if (canBeTyped) {
                result.add(word);
            }
        }

        // Return the result as an array of strings
        return result.toArray(new String[0]);
    }
}