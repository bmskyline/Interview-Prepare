class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n]; 
        ArrayDeque<Integer> num = new ArrayDeque();
        ArrayDeque<Integer> time = new ArrayDeque();
        for (String s : logs) {
            String[] split = s.split(":");
            if (split[1].equals("start")) {
                num.push(Integer.parseInt(split[0]));
                time.push(Integer.parseInt(split[2]));
            } else {
                int temp = Integer.parseInt(split[2]) - time.pop() + 1;
                num.pop();
                res[Integer.parseInt(split[0])] += temp;
                if (!num.isEmpty()) {
                    res[num.peek()] -= temp;
                }
            }
        }
        return res;
    }
}