class Solution {
    // Method to reverse a string represented as a character array.
    public void reverseString(char[] str) {
        // Initialize two pointers. One starting from the beginning (left) and
        // the other from the end of the array (right).
        int left = 0, right = str.length - 1;
      
        // Loop until the two pointers meet in the middle.
        while (left < right) {
            // Swap the characters at the left and right pointers.
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
          
            // Move the pointers towards each other.
            left++;
            right--;
        }
        // After the loop, the string is fully reversed in place.
    }
}