class Solution {
    public List<String> findStrobogrammatic(int n) {
        /*
        0
        1
        8
        6-9
        
        00
        
        101
        808
        609
        906
        8008
        */
        Queue<String> odd = new LinkedList();
        Queue<String> even = new LinkedList();
        int m = n;
        odd.offer("0");
        odd.offer("1");
        odd.offer("8");
        even.offer("00");
        even.offer("11");
        even.offer("88");
        even.offer("69");
        even.offer("96");
        if (n % 2 != 0) {
            while (n > 1) {
                int size = odd.size();
                for (int i = 0; i < size; i++) {
                    String s = odd.poll();
                    if (n > 3)
                        odd.offer("0"+s+"0");
                    odd.offer("1"+s+"1");
                    odd.offer("8"+s+"8");
                    odd.offer("6"+s+"9");
                    odd.offer("9"+s+"6");
                }
                n-=2;
            }
        } else  {
            while (n > 2) {
                int size = even.size();
                for (int i = 0; i < size; i++) {
                    String s = even.poll();
                    if (n > 4)
                        even.offer("0"+s+"0");
                    even.offer("1"+s+"1");
                    even.offer("8"+s+"8");
                    even.offer("6"+s+"9");
                    even.offer("9"+s+"6");
                }
                n-=2;
            }
        }
        if (m % 2 == 0) {
            if (m == 2)
                even.poll();
            return print(even);
        } 
        return print(odd);
    }
    
    List<String> print(Queue<String> q) {
        List<String> res = new ArrayList();
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}