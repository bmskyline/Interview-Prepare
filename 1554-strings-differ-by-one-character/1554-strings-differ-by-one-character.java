class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet();
        for (int i = 0; i < dict[0].length(); i++) {
            for (String s : dict) {
                StringBuilder cut = new StringBuilder(s).deleteCharAt(i);
                if (set.contains(cut.toString()))
                    return true;
                else set.add(cut.toString());
            }
            set.clear();
        }
        return false;
    }
}