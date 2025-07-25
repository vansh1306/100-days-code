class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Create a map to store the restaurants from list2 with their indices.
        Map<String, Integer> restaurantIndexMap = new HashMap<>();
        // Populate the map with the restaurants from list2.
        for (int i = 0; i < list2.length; ++i) {
            restaurantIndexMap.put(list2[i], i);
        }

        // Create a list to store the answer.
        List<String> commonRestaurants = new ArrayList<>();
        // Initialize minimum index sum with a large number.
        int minIndexSum = 2000;
      
        // Iterate through the list1 to find common restaurants with minimum index sum.
        for (int i = 0; i < list1.length; ++i) {
            // If the current restaurant is in list2,
            if (restaurantIndexMap.containsKey(list1[i])) {
                // Calculate the index sum.
                int currentIndexSum = i + restaurantIndexMap.get(list1[i]);
                // If the index sum is smaller than the minimum found so far,
                if (currentIndexSum < minIndexSum) {
                    // Start a new list as we found a restaurant with a smaller index sum.
                    commonRestaurants = new ArrayList<>();
                    // Add this restaurant to the list.
                    commonRestaurants.add(list1[i]);
                    // Update the minimum index sum.
                    minIndexSum = currentIndexSum;
                } else if (currentIndexSum == minIndexSum) {
                    // If the index sum is equal to the current minimum, add the restaurant to the list.
                    commonRestaurants.add(list1[i]);
                }
            }
        }
      
        // Return the list as an array.
        return commonRestaurants.toArray(new String[0]);
    }
}