class FirstUnique {

    List<Integer> list;
    Map<Integer, Boolean> set;
    public FirstUnique(int[] nums) {
        list = new ArrayList();
        set = new HashMap();
        for (int x : nums) {
            if (set.containsKey(x)) {
                if (set.get(x)) {
                    set.put(x, false);
                    list.remove(new Integer(x));
                }
            } else {
                list.add(x);
                set.put(x, true);
            }
        }
    }
    
    public int showFirstUnique() {
        if (list.isEmpty())
            return -1;
        return list.get(0);
    }
    
    public void add(int value) {
        if (set.containsKey(value)) {
            if (set.get(value)) {
                set.put(value, false);
                list.remove(new Integer(value));
            }
        } else {
            list.add(value);
            set.put(value, true);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */