class Solution {
    public int climbStairs(int n, int[] costs) {
        /*
        step
            4
                1

        0 1 2 3  4
        0 2 6 12 
        */
        int[] mem = new int[n + 1];
        mem[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = mem[i - 1] + 1;

            if (i >= 2) {
                min = Math.min(min, mem[i - 2] + 4);
            }

            if (i >= 3) {
                min = Math.min(min, mem[i - 3] + 9);
            }

            mem[i] = costs[i - 1] + min;
        }
        return mem[n];
    }
}