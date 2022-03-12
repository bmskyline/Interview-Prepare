class LRUCache {

    /*
    Map<key, Node> 
    1 1 
    2 2
    3 3
    
    1     2     3
    tien  manh  tan
    */
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            delete(node);
            map.remove(key);
            addToHead(key, node.val);
            map.put(key, head.next);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            delete(map.get(key));
            map.remove(key);
            addToHead(key, value);
            map.put(key, head.next);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                delete(tail.pre);
            }
            addToHead(key, value);
            map.put(key, head.next);
        }
    }
    
    private void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
      }
  
    private void addToHead(int key, int value){
        Node node = new Node(value, key);
        Node headNext = head.next;
        head.next = node;
        node.pre = head;
        headNext.pre = node;
        node.next = headNext;
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node pre;
    public Node(int val, int key) {
        this.val = val;
        this.key = key;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */