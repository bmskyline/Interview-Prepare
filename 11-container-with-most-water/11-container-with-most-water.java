class Solution {
    public int maxArea(int[] h) {
        int max = 0;
        int st = 0;
        int end = h.length -1;
        while (st < end) {
            max = Math.max(max, Math.min(h[st], h[end]) * (end - st));
            if (h[st] < h[end]){
                st++;
            } else  {
                end--;
            }
        }
        return max;
    }
}