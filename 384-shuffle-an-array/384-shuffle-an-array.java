class Solution {

    int[] ori;
    int[] array;
    Random rand;
    public Solution(int[] nums) {
        ori = nums;
        array = nums.clone();
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int index = 0; index < array.length; index++) {
            int a = rand.nextInt(0, array.length);
            int temp = array[index];
            array[index] = array[a];
            array[a] = temp;
        }
        return array;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */