class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        newInterval certainly not create overlap if is inserted
        can start interval overlap end of previous one
        if have overlap I have to merge inteval
        solution : 
        merger intevral
        1   4        2 3
         2 3       1      4
        1  3         2    4
          2  4     1    3
          2   4    1    3
        1   3         2    4
        */
        List<int[]> result = new LinkedList<>();
	    int i = 0;
	    while (i < intervals.length && intervals[i][1] < newInterval[0]){
	        result.add(intervals[i]);
	        i++;
	    }
	    
	    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
	        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	        i++;
	    }
	    
	    result.add(newInterval); 
	    
	    while (i < intervals.length){
	    	result.add(intervals[i]); 
	    	i++;
	    }
	    
	    return result.toArray(new int[result.size()][]);
    }
    /*
    Time complexity : O(n)
    Space complexity : O(n)
    */
}