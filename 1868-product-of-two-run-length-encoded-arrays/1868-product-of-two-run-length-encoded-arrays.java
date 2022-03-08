class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        /*
        i = 3
        j = 3
        i > 0
        j > 0
        i = 0
        
        */
        int remain1 = encoded1[0][1];
        int remain2 = encoded2[0][1];
        int num1 = encoded1[0][0];
        int num2 = encoded2[0][0];
        int idx1 = 1;
        int idx2 = 1;
        List<List<Integer>> res = new ArrayList();
        while (remain1 > 0 && remain2 > 0) {
            List<Integer> list = new ArrayList();
            list.add(num1 * num2);
            int min = Math.min(remain1, remain2);
            list.add(min);
            if (res.isEmpty()) {
                res.add(list);
            } else {
                List<Integer> last = res.get(res.size() - 1);
                if (list.get(0).equals(last.get(0))) {
                    last.set(1, last.get(1) + list.get(1));
                    res.set(res.size() - 1, last);
                } else {
                    res.add(list);
                }
            }
            remain1 -= min;
            remain2 -= min;
            if (remain1 == 0 && idx1 < encoded1.length) {
                remain1 = encoded1[idx1][1];
                num1 = encoded1[idx1][0];
                idx1++;
            }
            if (remain2 == 0 && idx2 < encoded2.length) {
                remain2 = encoded2[idx2][1];
                num2 = encoded2[idx2][0];
                idx2++;
            }
        }
        return res;
    }
}