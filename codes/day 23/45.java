import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Checks if the array contains any duplicates.
     *
     * @param numbers The array of integers to check for duplicates.
     * @return true if any value appears at least twice in the array, and false if every element is distinct.
     */
    public boolean containsDuplicate(int[] numbers) {
        // Initialize a HashSet to store unique elements.
        Set<Integer> uniqueNumbers = new HashSet<>();
      
        // Iterate through all the elements in the array.
        for (int number : numbers) {
            // Attempt to add the current element to the set.
            // If the add method returns false, it means the element is already present in the set.
            if (!uniqueNumbers.add(number)) {
                // Duplicate found, so return true.
                return true;
            }
        }
      
        // No duplicates were found, return false.
        return false;
    }
}