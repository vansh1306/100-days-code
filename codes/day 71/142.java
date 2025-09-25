class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            int rigthWindowStart = i + 1;
            if (nums[i] >= nums[rigthWindowStart]) {
                // continue until right window ([i, nums.length - 1]) is sorted in desc order
                continue;
            }
            
            // === Stop of desc right window ===
            
            // 1) find lowest element nums[j] in the right window that's greater than nums[i]
            int j = binarySearchForLowestGT(nums, nums[i], rigthWindowStart);
            // 2) swap nums[j] and nums[i] values
            swap(nums, i, j);
            // 3) reverse elements in right window => asc order
            reverse(nums, rigthWindowStart);
            
            return; 
        }

        // if nums is desc array then completely reverse it => asc order array
        reverse(nums, 0);
    }

    private static void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int binarySearchForLowestGT(int[] arr, int lessTarget, int start) {
        int result = -1;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > lessTarget) {
                result = mid; // potential candidate, try to find a smaller index
                start = mid + 1; // move right because array is descending
            
            } else if (result != -1) { 
                return result;
            
            } else {
                end = mid - 1; // move left
            }
        }

        return result; // index of lowest value > lessTarget, or -1 if not found
    }

}