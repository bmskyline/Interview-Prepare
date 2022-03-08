class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(n != 1) {
            n = nextNumber(n);
            if(set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return n == 1;
    }
    
    public int nextNumber(int num) {
        int sum = 0;
        while(num > 0) {
            int a = num%10;
            sum += (a*a);
            num = num/10;
        }
        return sum;
    }
}