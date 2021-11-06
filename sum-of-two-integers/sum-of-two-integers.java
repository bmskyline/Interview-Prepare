class Solution {
    public int getSum(int a, int b) {
        /*
        001
        010
        011
        010
        011
        101
        */
        int res = 0;
        boolean save = false;
        for (int i = 0; i < 32; i++) {
            if (((a>>i) & 1) > 0 && ((b>>i) & 1) > 0) {
                if (save) {
                    res = res | (1<<i);
                } else {
                    save = true;
                }
            } else if (((a>>i) & 1) > 0) {
                if (!save) {
                    res = res | (1<<i);
                }
            } else if (((b>>i) & 1) > 0) {
                if (!save) {
                    res = res | (1<<i);
                }
            } else {
                if (save) {
                    res = res | (1<<i);
                    save = false;
                }
            }
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}