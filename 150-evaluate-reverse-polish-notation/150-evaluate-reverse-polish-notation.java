class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a+b);
            } else if (tokens[i].equals("-")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a-b);
            } else if (tokens[i].equals("*")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a*b);
            } else if (tokens[i].equals("/")) {
                int b = s.pop();
                int a = s.pop();
                s.push(a/b);
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}