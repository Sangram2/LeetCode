class MyCalendarTwo {

    public MyCalendarTwo() {
        intersection = new ArrayList<>();
        slots = new ArrayList<>();
    }
    public ArrayList<int[]> intersection;
    public ArrayList<int[]> slots;
    public boolean book(int start, int end) {
        for(int[] arr : intersection){
            if(Math.max(arr[0],start)<Math.min(arr[1],end)){
                return false;
            }
        }
        for(int[] d:slots){
            if(Math.max(start,d[0]) < Math.min(end,d[1])){
                intersection.add(new int[]{Math.max(start,d[0]),Math.min(end,d[1])});
            }
        }
        slots.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */