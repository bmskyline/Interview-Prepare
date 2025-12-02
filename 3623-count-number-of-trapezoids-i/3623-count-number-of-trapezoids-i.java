class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> edge = new HashMap();
        final int mod = 1000000007;
        long res = 0;
        long sum = 0;
        for (int[] point : points) {
            edge.put(point[1], edge.getOrDefault(point[1], 0) + 1);
        }
        for (int num : edge.values()) {
            long e = ((long) num * (num - 1)) / 2;
            res = (res + e * sum) % mod;
            sum = (sum + e) % mod;
        }
        return (int) res;
    }
}