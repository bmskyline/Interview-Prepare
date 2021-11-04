class MyCalendar {

    List<int[]> booking;
    public MyCalendar() {
        booking = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for (int i = 0; i < booking.size(); i++) {
            if (start < booking.get(i)[1] && end > booking.get(i)[0]) {
                return false;
            } else if (end <= booking.get(i)[0]) {
                booking.add(i, new int[] {start, end});
                return true;
            }
        }
        booking.add(new int[] {start, end});
        return true;
    }
    /*
    Time complexity : O(n)
    Space complexity : O(1)
    */
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */