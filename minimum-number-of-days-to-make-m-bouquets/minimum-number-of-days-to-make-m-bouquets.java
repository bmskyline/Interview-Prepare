class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        /*
        1
        1  x - - - -
        2  x---x
        3  x-x-x
        
        7 xxxx-x
        */
        if (bloomDay.length < m*k)
            return -1;
        
        int[] arr = bloomDay.clone();
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(bloomDay, arr[mid], k, m)) {
                r = mid;
            } else {
                l = mid + 1;
            }
            
        }
        if (l == r)
            return arr[l];
        return -1;
    }
    
    boolean check (int[] bloomDay, int x, int k, int m) {
        int count = 0;
        int ms = m;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= x) {
                count++;
                if (count == k) {
                    ms--;
                    count = 0;
                    if (ms == 0) {
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(n)
    */
}