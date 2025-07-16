class Solution {
    // Method to find the maximum number of content children given the greed factors of children and the sizes of cookies
    public int findContentChildren(int[] greedFactors, int[] cookieSizes) {
        // Sort the arrays to make the greedy assignment possible
        Arrays.sort(greedFactors);
        Arrays.sort(cookieSizes);

        int numberOfChildren = greedFactors.length;   // Total number of children
        int numberOfCookies = cookieSizes.length;     // Total number of cookies available

        // Initialize the count for content children
        int contentChildrenCount = 0;

        // Initialize pointers for greedFactors and cookieSizes arrays
        int greedFactorIndex = 0;
        int cookieSizeIndex = 0;

        // Loop through each child's greed factor
        while (greedFactorIndex < numberOfChildren) {
          
            // Find the first cookie that satisfies the current child's greed factor
            while (cookieSizeIndex < numberOfCookies && cookieSizes[cookieSizeIndex] < greedFactors[greedFactorIndex]) {
                cookieSizeIndex++;  // Increment cookie index until a big enough cookie is found
            }
          
            // If a cookie that satisfies the current child's greed factor is found, consider the child content
            if (cookieSizeIndex < numberOfCookies) {
                contentChildrenCount++;       // Increment the count of content children
                cookieSizeIndex++;            // Move to the next cookie
            } else {
                // If no more cookies are available to satisfy any more children, break out of the loop
                break;
            }

            // Move to the next child
            greedFactorIndex++;
        }

        // Return the final count of content children
        return contentChildrenCount;
    }
}