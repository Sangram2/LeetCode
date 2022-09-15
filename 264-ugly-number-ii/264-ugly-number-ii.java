class Solution {
    public int nthUglyNumber(int n) {
//         if(n==1){
//             return 1;
//         }
        
//         int start =1;
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         HashSet<Integer> hs = new HashSet<>();
//         hs.add(1);
//         pq.add(1);
//         while(n-->0){
//             start = pq.remove();
//             // System.out.println(start);
//             if(!hs.contains(2*start)){
//                 pq.add(2*start);
//                 hs.add(2*start);
//             }
//             if(!hs.contains(3*start)){
//                 pq.add(3*start);
//                 hs.add(3*start);
//             }
//             if(!hs.contains(5*start)){
//                 pq.add(5*start);
//                 hs.add(5*start);
//             }
            
//         }
//         return start;
        
        int[] dp = new int[n+1];
        int i = 1;
        int j = 1;
        int k = 1;
        dp[1] = 1;
        int idx = 2;
        while(idx<=n){
            int a = 2*dp[i];
            int b = 3*dp[j];
            int c = 5*dp[k];
            int m = Math.min(a,Math.min(b,c)); 
            dp[idx] = m;
            if(2*dp[i] == m){
                i++;
            }
            if(3*dp[j] == m){
                j++;
            }
            if(5*dp[k] == m){
                k++;
            }
            idx++;
        }
        return dp[n];
        
        
    }
}