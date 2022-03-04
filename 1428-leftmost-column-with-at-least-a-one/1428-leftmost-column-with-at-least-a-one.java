/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix mat) {
        List<Integer> list = mat.dimensions();
        int min = list.get(1);
        for (int i = 0; i < list.get(0); i++) {
            int l = 0;
            int r = list.get(1) - 1;
            while (l < r) {
                int m = l + (r - l)/2;
                if (mat.get(i, m) == 1) {
                    r = m;
                } else {
                    l = m + 1; 
                }
            }
            if (mat.get(i, l) == 1)
                min = Math.min(min, l);
        }
        
        return min == list.get(1) ? -1 : min;
    }
}