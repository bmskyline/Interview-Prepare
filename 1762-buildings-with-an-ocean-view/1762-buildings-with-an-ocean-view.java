class Solution {
    /*
    1 3 2 4
    1 3 4
    */
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList();
        list.add(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > heights[list.get(list.size() - 1)]) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            res[list.size() - i - 1] = list.get(i);
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}