// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Node dummy;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        dummy = new Node(0, null);
        Node cur = dummy;
	    while (iterator.hasNext()) {
            cur.next = new Node(iterator.next(), null);
            cur = cur.next;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return dummy.next.val;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        dummy = dummy.next;
	    return dummy.val;
	}
	
	@Override
	public boolean hasNext() {
	    return dummy.next != null;
	}
}

class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}