class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        /*
        4 6 8 
        
        2 4
        2 4 6 8 10
        4 8 16
        */
        int MOD = 1000000007;
        int l = a / gcd(a, b) * b;

        long lo = 0;
        long hi = (long) n * Math.min(a, b);
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (mi / a + mi / b - mi / l < n)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % MOD);
    }
    
    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}