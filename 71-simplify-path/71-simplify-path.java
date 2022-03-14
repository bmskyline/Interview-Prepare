class Solution {
    public String simplifyPath(String path) {
        /*
        /home/
        /string
        
        /
        
        */
        String[] split = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque();
        for (String s : split) {
            if (s.equals(".") || s.equals("")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, "/");
            
        }
        return res.length() == 0 ? "/" : res.toString();
    }
    
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}