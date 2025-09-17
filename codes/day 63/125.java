class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length = Math.max(nums1.length, nums2.length);
        int[] arr = new int[length];
        int index = 0;
        int i=0;
        int j=0;
        while (i < nums1.length && j < nums2.length) {

            if(nums1[i] < nums2[j]) {
                i++;
            }
            else if(nums2[j] < nums1[i]) {
                j++;
            }

            else {
                arr[index] = nums1[i];
                index++;
                i++;
                j++; 
            }
        }

        int[] res = new int[index];
        for(int k=0;k<index;k++) {
            res[k] = arr[k];
        }

        //return Arrays.copyOfRange(arr, 0, index);
        return res;
    }
}