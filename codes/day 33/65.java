class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        
        int n= arr.length;
        int low=0;
        int high = n-1;
        int ans =Integer.MAX_VALUE;
        
        while(low<=high){
            int mid= (low+high)/2;
            
            if(arr[mid]==k){
                ans = Math.min(ans, mid);
                high = mid-1;
                
                // return mid;
            }
            else if(k<arr[mid])
                high=mid-1;
            else
                low = mid +1;
        }
        if(ans!=Integer.MAX_VALUE)  return ans;
        return -1;
        
    }
}