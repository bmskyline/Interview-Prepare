class Solution {
    public int[] closestDivisors(int num) {
        /*
        9 10
        3 3,1 10/3 10/2 10/1
        123
        124 125
        0 - 11
        7
        */
        int a = 0;
        int diff = 0;
        int first = (int) Math.sqrt(num+1);
        while ((num+1) % first != 0) {
            first--;
        }
        a = (num+1) / first;
        diff = Math.abs(first - a);
        int second = (int) Math.sqrt(num+2);
        while ((num+2) % second != 0) {
            second--;
        }
        if (Math.abs(second - ((num+2)/second)) < diff) {
            return new int[] {second, (num+2)/second};
        } else {
            return new int[] {first, a};
        }
    }
    /*
    Time complexity : O(sqrt(n))
    Space complexity : O(1)
    */
}