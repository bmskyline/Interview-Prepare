class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        /*
        The easiest way to resolved it is bruthforce
        I will loop all elemenet in the arr1, then check the condition, if it match, result +1
        O(n*m)
        */
        int res = 0;
        outer:
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d)
                    continue outer;
            }
            res++;
        }
        return res;
    }
}