class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a,b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else if (a.length() > b.length()) {
                return -1;
            } else {
                return 1;
            }
        });
        for (String str : dictionary) {
            if (deleting(s, str))
                return str;
        }
        return "";
    }
    
    boolean deleting(String s, String str) {
        int i = 0; 
        int j = 0;
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == str.length();
    }
    
    /*
    Time complexity : O(nlogn)
    Spave complexity : O(logn)
    */
}