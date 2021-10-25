class Solution {
    public int compareVersion(String version1, String version2) {
        /*
        1.01
        1.001
        0 1
        0 1
        */
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < ver1.length && pointer2 < ver2.length) {
            if (Integer.parseInt(ver1[pointer1]) == Integer.parseInt(ver2[pointer2])) {
                pointer1++;
                pointer2++;
            } else if (Integer.parseInt(ver1[pointer1]) > Integer.parseInt(ver2[pointer2])) {
                return 1;
            } else {
                return -1;
            }
        }
        while (pointer1 < ver1.length) {
            if (Integer.parseInt(ver1[pointer1]) > 0)
                return 1;
            pointer1++;
        }
        while (pointer2 < ver2.length) {
            if (Integer.parseInt(ver2[pointer2]) > 0)
                return -1;
            pointer2++;
        }
        return 0;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}