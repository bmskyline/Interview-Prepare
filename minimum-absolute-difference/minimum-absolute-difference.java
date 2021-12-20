class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList();
        int min = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i+1] - arr[i];
            if (temp == min) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            } else if (temp < min) {
                min = temp;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return res;
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(n)
    */
}