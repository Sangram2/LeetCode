class MyCalendar {

    public MyCalendar() {
        
    }
    public ArrayList<int[]> events = new ArrayList<>();
    public boolean book(int start, int end) {
        for(int[] e :events){
            if(Math.max(e[0],start)<Math.min(e[1],end)){return false;}
        }
        
        events.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */