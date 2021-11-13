class Solution {
    public int[] dailyTemperatures(int[] tem) {
        if (tem.length == 1)
            return new int[] {0};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[tem.length];
        for(int i = 0; i < tem.length; i++) {
            while(!stack.empty() && tem[i] > tem[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}