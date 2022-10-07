class MyCalendarThree {

    public MyCalendarThree() {
        
    }
    public TreeMap<Integer,Integer> tm = new TreeMap<>();
    
    public int book(int start, int end) {
        tm.put(start,tm.getOrDefault(start,0)+1);
        tm.put(end,tm.getOrDefault(end,0)-1);
        int ans = 0,l = 0;
        for(int d:tm.values()){
            l+=d;
            ans = Math.max(l,ans);
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */