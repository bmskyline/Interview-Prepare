class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        /*
        100 200 300 400
                lr 
        300
        1
        
        power 6
        score 3
        5 7 8 10 20 21
                 lr
        */
        Arrays.sort(tokens);
        int score = 0;
        int l = 0;
        int r = tokens.length - 1;
        while (l < r) {
            if (power >= tokens[l]) {
                power -= tokens[l];
                score++;
                l++;
            } else {
                if (score > 0) {
                    score--;
                    power += tokens[r];
                    r--;
                } else {
                    return score;
                }
                
            }
        }
        if (l == r && power >= tokens[l])
            score++;
        return score;
    }
    /*
    Time complexity : O(nlogn)
    Space complexity : O(logn)
    */
}