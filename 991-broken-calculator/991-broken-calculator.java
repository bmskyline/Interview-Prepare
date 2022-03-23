class Solution {
    public int brokenCalc(int startValue, int target) {
        /*
        8 5
        4 5
        10
        5
        6
        2
        
        */
        if (startValue > target) {
            return startValue - target;
        }
        int count = 0;
        while (startValue != target) {
            if (startValue < target && target % 2 == 0) {
                target /= 2;
            } else {
                target += 1;
            }
            count++;
        }
        return count;
    }
}