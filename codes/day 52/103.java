class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int array[] = mergeTwoArray(nums1, nums2);
        array = sortTwoArray(array);
        double median = calcMedianOfArray(array);
        displayMergeArray(array);
        displayFinalArray(nums1,nums2,median);
        return median;   
    }
    
    public static double calcMedianOfArray(int[] array)
    {
        int n = array.length;
        int midpoint;
        double midValue;
        if (n % 2 != 0) {
            midpoint = (n + 1) / 2;
            midValue = array[midpoint - 1];
            return midValue;
        } else {
            int midIndex2 = n / 2; 
            int midIndex1 = (n - 1) / 2;
            midValue = (array[midIndex1] + array[midIndex2]) / 2.0;
            return midValue;
        }
    }
    public static int[] sortTwoArray(int[] array)
    {
        int swap;
        for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array.length; j++) {
               if (array[i] < array[j]) {
                   swap = array[i];
                   array[i] = array[j];
                   array[j] = swap;
                }               
           }           
        }
        return array;
    }
    public static int[] mergeTwoArray(int[] nums1,int[] nums2)
    {
        int sortArraySize = calcSizeOfMergeArray(nums1, nums2);
        int array[] = new int[sortArraySize];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= nums1.length) {
                array[i] = nums2[j];
                j++;
            } else {
                array[i] = nums1[i];
            }
        }
        return array;
    } 
    public static int calcSizeOfMergeArray(int[] nums1 , int[] nums2)
    {
        return nums1.length + nums2.length;
    }
    public static void displayMergeArray(int[] array)
    {
        System.out.println("Merge Array Is :::::::::::::::: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
    
    public static int[] getArrayFromUser()
    {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size Of An Array ::: ");
        int size = sc.nextInt(); 
        int arr[] = new int[size];
        System.out.println("Enter Element Of An Array ::::: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); 
        }
        return arr;

    }

    public static void displayFinalArray(int[] nums1, int[] nums2 , double median)
    {

        System.out.println();
        System.out.println("Your Mid Value Of an Array Is :::::::::  " + median);
        System.out.println();
        System.out.println("First Array ::::::::::::::::::: ");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
        System.out.println();
        System.out.println("Second Array ::::::::::::::::::: ");

        for (int j = 0; j < nums2.length; j++) {
            System.out.print(nums2[j] + ",");
            
        }
    }
}