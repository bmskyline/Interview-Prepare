class Solution {

    /*
    sum = 4
    
    */
    int[] preSum;
    Random rand;
    public Solution(int[] w) {
        preSum = w;
        rand = new Random();
        for (int i = 1; i < w.length; i++) {
            preSum[i] += preSum[i-1]; 
        }
    }
    
    public int pickIndex() {
        if (preSum.length == 1)
            return 0;
        int idx = rand.nextInt(preSum[preSum.length - 1]) + 1;
        int left = 0, right = preSum.length - 1;
        // search position 
        while(left < right){
            int mid = left + (right-left)/2;
            if(preSum[mid] == idx)
                return mid;
            else if(preSum[mid] < idx)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
/*
Time complexity :
- constructor : O(n)
- pickIndex : O(logn)
Space complexity : O(n)
*/
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */