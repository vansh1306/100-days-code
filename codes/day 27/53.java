class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Use a stack to keep track of the elements for which we want to find the next greater element
        Deque<Integer> stack = new ArrayDeque<>();
        // Create a map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
      
        // Loop through each element in nums2
        for (int num : nums2) {
            // While there is an element in the stack and it is smaller than the current number
            while (!stack.isEmpty() && stack.peek() < num) {
                // Pop the element from the stack and put its next greater element (num) in the map
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack
            stack.push(num);
        }
      
        // Initialize the array to store the next greater elements for nums1
        int n = nums1.length;
        int[] result = new int[n];
      
        // Loop through each element in nums1
        for (int i = 0; i < n; ++i) {
            // If nums1[i] has a next greater element in nums2, use it; otherwise, use -1
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        // Return the result array with the next greater elements for nums1
        return result;
    }
}