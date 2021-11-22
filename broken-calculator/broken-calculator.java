class Solution {
    public int brokenCalc(int startValue, int target) {
        /*
        6
        17
        17+1 = 18
        18/2 = 9
        9+1 = 10
        10/2 = 5
        5+1 = 6
        
        */
        int count = 0;
        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target +=1;
            }
            count++;
        }
        while (target < startValue) {
            target++;
            count++;
        }
        return count;
    }
    /*
    Time complexity : O(logn)
    Space complexity : O(1)
    */
}