class Solution {
    public int findKthLargest(int[] nums, int k) {
        return kthSmallest(nums, 0, nums.length - 1, k);
    }
    
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }
 
        // swapping pivot to the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;
 
        return pivotloc;
    }
 
    // finds the kth position (of the sorted array)
    // in a given unsorted array i.e this function
    // can be used to find both kth largest and
    // kth smallest element in the array.
    // ASSUMPTION: all elements in arr[] are distinct
    public int kthSmallest(int[] arr, int low,
                                  int high, int k)
    {
        // find the partition
        int partition = partition(arr, low, high);
 
        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == arr.length - k)
            return arr[partition];
 
        // if partition value is less than kth position,
        // search right side of the array.
        else if (partition < arr.length - k)
            return kthSmallest(arr, partition + 1, high, k);
 
        // if partition value is more than kth position,
        // search left side of the array.
        else
            return kthSmallest(arr, low, partition - 1, k);
    }
}