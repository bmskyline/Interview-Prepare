class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        List<int[]> list = new ArrayList();
        int f = 0;
        int s = 0;
        while (f < first.length && s < second.length) {
            if (first[f][1] < second[s][0]) {
                f++;
            } else if (second[s][1] < first[f][0]) {
                s++;
            } else if (first[f][0] <= second[s][0] && first[f][1] < second[s][1]){
                list.add(new int[] {second[s][0], first[f][1]});
                f++;
            } else if (first[f][0] <= second[s][0] && first[f][1] > second[s][1]){
                list.add(new int[] {second[s][0], second[s][1]});
                s++;
            } else if (first[f][0] >= second[s][0] && first[f][1] < second[s][1]){
                list.add(new int[] {first[f][0], first[f][1]});
                f++;
            } else if (first[f][0] >= second[s][0] && first[f][1] > second[s][1]){
                list.add(new int[] {first[f][0], second[s][1]});
                s++;
            } else {
                list.add(new int[] {Math.max(first[f][0],second[s][0]), second[s][1]});
                s++;
                f++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    /*
    Time complexity : O(n)
    Space complexity: O(n)
    */
}