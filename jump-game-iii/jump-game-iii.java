class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0)
            return true;
        arr[start] = 0 - arr[start];
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}