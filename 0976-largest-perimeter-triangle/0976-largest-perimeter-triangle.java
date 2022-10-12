class Solution {
    public int largestPerimeter(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int len:nums){
            pq.add(len);
        }
        while(pq.size()>=3){
            int a = pq.remove();
            int b = pq.remove();
            int c = pq.remove();
            if(check(a,b,c)){
                return a+b+c;
            }else{
                pq.add(b);
                pq.add(c);
            }
        }
        return 0;
    }
    boolean check(int a,int b,int c){
        boolean ans = true;
        if(a+b<=c){
            ans = false;
        }
        else if(a+c<=b){
            ans = false;
        }
        else if(b+c<=a){
            ans = false;
        }
        return ans;
    }
}