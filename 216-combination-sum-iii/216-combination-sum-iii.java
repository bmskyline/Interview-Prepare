class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        /*
        we will select 3 numbers 
        so it sum equal to 7
        if we choose 2 we will canno select number <= 2
        */
        res = new ArrayList();
        helper(k, n, new ArrayList(), 0);
        return res;
    }
    
    void helper(int k, int n, List<Integer> list, int prev) {
        if (list.size() == k) {
            if (n == 0)
                res.add(new ArrayList(list));
            return;
        }
        for (int i = prev + 1; i <= 9; i++) {
            list.add(i);
            helper(k, n - i, list, i);
            list.remove(list.size() - 1);
        }
    }
}