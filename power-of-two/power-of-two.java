class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0)
            return false;
        boolean isPower = false;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) > 0) {
                if(!isPower) {
                    isPower = true;
                } else {
                    return false;
                }
            }
        }
        return isPower;
    }
}