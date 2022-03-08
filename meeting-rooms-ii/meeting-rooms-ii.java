class Solution {
    public int minMeetingRooms(int[][] intervals) {
        /*
        0 30 5 10 5 20
        30
        20
        */
        if (intervals == null || intervals.length == 0)
            return 0;
        // sort the arrays by start time
        Arrays.sort(intervals, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b) {return a[0] - b[0];}
        });
        // sort the heap by end time (scheduled meeting)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(intervals.length, new Comparator<int[]>(){
           @Override 
            public int compare (int[] a, int[] b) {return a[1] - b[1];}
        });

        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] earliest = pq.poll();
            int[] curInterval = intervals[i];

            if (earliest[1] <= curInterval[0]){
                earliest[1] = curInterval[1]; // merge (use the same room)
            } else {
                pq.offer(curInterval); // schedule a new room
            }

            pq.offer(earliest);
        }

        return pq.size();
    }
}