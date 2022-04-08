class SnapshotArray {

    /*
    1 2 3 4 5
    1 5 3 4 5
    snap 0 chagne 2 - 5
    1 3 3 4 5
    snap 1
    get(1, )
    1, change 5 -3
    map map map map map
    
    */
    TreeMap<Integer, Integer>[] array;
    int curSnap = 0;
    public SnapshotArray(int length) {
        array = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            array[i] = new TreeMap();
        }
    }
    
    public void set(int index, int val) {
        array[index].put(curSnap, val);
    }
    
    public int snap() {
        curSnap++;
        return curSnap - 1;
    }
    
    public int get(int index, int snap_id) {
        Integer key = array[index].floorKey(Integer.valueOf(snap_id));
        return key == null ? 0 : array[index].get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */