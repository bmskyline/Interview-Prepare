class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        /*
        i = 3
        j = 3
        i > 0
        j > 0
        i = 0
        
        */
        int idx1 = 0, idx2 = 0;
        List<List<Integer>> res = new ArrayList<>();
		
        while (idx1 < encoded1.length) {
            int len = Math.min(encoded1[idx1][1], encoded2[idx2][1]);
            int mult = encoded1[idx1][0] * encoded2[idx2][0];
            
            if (res.size() > 0 && res.get(res.size() - 1).get(0) == mult)
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1)+len);
            else
                res.add(Arrays.asList(mult, len));
            
			encoded1[idx1][1] -= len;
            encoded2[idx2][1] -= len;
            if(encoded1[idx1][1] == 0) 
                idx1++;
            if(encoded2[idx2][1] == 0) 
                idx2++;
        }
        return res;
    }
}