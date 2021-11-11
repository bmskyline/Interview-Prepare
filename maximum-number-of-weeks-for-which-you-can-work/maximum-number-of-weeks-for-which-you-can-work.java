class Solution {
    public long numberOfWeeks(int[] milestones) {
        int max = 0;
        long sum = 0;
        for (int x : milestones) {
            sum += x;
            if (x > max)
                max = x;
        }
        
        if (max > sum - max + 1) {
            return (sum - max) * 2 +1;
        }
        return sum;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}