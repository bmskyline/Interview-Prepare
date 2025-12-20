class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int[] save = new int[strs[0].length()];
        Set<Integer> set = new HashSet();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (i > 0) {
                    if (strs[i].charAt(j) < save[j] && !set.contains(j)) {
                        count++;
                        set.add(j);
                    }
                }
                save[j] = strs[i].charAt(j);
            }
        }
        return count;
    }
}