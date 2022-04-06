class NumArray {

    int[] nums;
    int[] BIT;
    public NumArray(int[] nums) {
        this.nums = nums;
        BIT = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        init(index, diff);
    }
    
    void init(int i, int val) {
        i++;
        while (i <= nums.length) {
            BIT[i] += val;
			i += (i & -i);
        }
    }
    
    int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
			i -= (i & -i);
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */