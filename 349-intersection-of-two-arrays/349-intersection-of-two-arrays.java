class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> map = new HashSet();
        for (int x : nums1) {
            map.add(x);
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int i = 0;
        for (int x : nums2) {
            if (map.contains(x)) {
                res[i] = x;
                map.remove(x);
                i++;
            }
        }
        return Arrays.copyOf(res, i);
    }
}