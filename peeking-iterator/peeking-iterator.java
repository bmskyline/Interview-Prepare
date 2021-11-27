// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Node head;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        head = new Node();
        Node cur = head;
	    while (iterator.hasNext()) {
            Integer element = iterator.next();
            cur.next = new Node(element, null);
            cur = cur.next;
        }
        head = head.next;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return head.val;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer res = head.val;
        head = head.next;
	    return res;
	}
	
	@Override
	public boolean hasNext() {
	    if (head == null)
            return false;
        return true;
	}
}
/*
Time complexity : O(n) every method is O(1)
Space complexity : O(n)
*/

class Node {
    int val;
    Node next;
    public Node() {}
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    } 
}