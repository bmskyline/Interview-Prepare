class Solution {
    public int smallestRepunitDivByK(int k) {
        /*
        if even number return -1
        if k = 1 -> 1
        1 / k
        11/ k
        111/k
        
        111/3
        37
        11 * 10 +1
        */
        if (k % 2 == 0 || k % 5 == 0)
            return -1;
        int count = 1, number = 1;
        while (number % k != 0) {
            number = (number * 10 + 1) % k;
            count++;
        }
        return count;
    }
}