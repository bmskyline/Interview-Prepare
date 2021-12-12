class Solution {
    public boolean canPartition(int[] nums) {
        /*
        1 5 11 5
        1  (5 11 5)
        1 5 (11 5)
        1 5 11 
        1 5 5
         
        1 1 3  5 5 6 6 12 
        
        count the sum if % 2 equal 1 return false
        for every num
        you will get or not get num
        
        
        */
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
            if (dp[sum])
                return true;
        }
        return dp[sum];      
    }
}