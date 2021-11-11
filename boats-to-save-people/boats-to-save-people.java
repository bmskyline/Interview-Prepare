class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
        3 2 2 1
        3 31 2
        3 5 3 4
        5 4 3 3
        1 2 4 5 6
        6
        1 2 4 5
        7
        1 6
        2 5
        4
        1 1 1 4 5 6
        50  49 47,2 41,2,2 33,6,6 26,7,10 22,10,10 18,11 12,13
        */
        Arrays.sort(people);
        int count = 0;
        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            count++;
            if (people[r] + people[l] <= limit) {
                l++;
            }
            r--;
        }
        return count;
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(logn)
    */
}