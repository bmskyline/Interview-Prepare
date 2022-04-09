class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < speed.length; i++) {
            map.put(position[i], (double) (target - position[i])/speed[i]);
        }
        int count = 0;
        double r = -1;
        for (double x : map.values()) {
            if (x > r) {
                count++;
                r = x;
            }
        }
        return count;
    }
}