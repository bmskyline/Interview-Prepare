class Solution {
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        if (visited == null)
            visited = new boolean[arr.length];
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }
        visited[start] = true;
        if (arr[start] == 0)
            return true;
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}