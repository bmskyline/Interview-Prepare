class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxsize = 0;
        if ( len == 0) return 0 ;
        Stack<Integer> hstack = new Stack<>();
        Stack<Integer> pstack = new Stack<>();
        for (int i = 0; i <= len; i++){
            int currheight;
            if (i == len) {
                currheight = 0;
            } else currheight = heights[i];
            
            if (hstack.empty() || currheight > hstack.peek()){
                hstack.push(currheight);
                pstack.push(i);
            } else if(currheight<hstack.peek()){
                int last = -1;
                while(!hstack.empty() && currheight < hstack.peek()){
                    maxsize = maxsize > (i-pstack.peek())*hstack.peek() ? maxsize :(i-pstack.peek())*hstack.peek();
                    last = pstack.pop();
                    hstack.pop();
                }
                pstack.push(last);
                hstack.push(currheight);
            }
        }
        return maxsize;
    }
}