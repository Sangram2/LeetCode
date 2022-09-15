class Solution {
//     public int nthSuperUglyNumber(int n, int[] primes) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         HashSet<Integer> hs = new HashSet<>();
//         pq.add(1);
//         int st = 1;
//         while(n-->0){
//             st = pq.remove();
            
//             for(int p:primes){
//                 if(hs.contains(st*p)){
//                     continue;
//                 }
//                 pq.add(st*p);
//                 hs.add(st*p);
//             }
//         }
//         return st;
//     }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pos = new int[primes.length];
        Arrays.fill(pos,1);
        int[] dp =new int[n+1];
        dp[1] = 1;
        for(int j = 2;j <= n; j++){
            long min = Long.MAX_VALUE;
            for(int i = 0;i<pos.length;i++){
                int p = pos[i];
                int prim = primes[i];
                int val = dp[p];
                min = Math.min((long)min,(long)val*prim);
            }
            dp[j] = (int)min;
            for(int i = 0;i<pos.length;i++){
                int p = pos[i];
                int prim = primes[i];
                int val = dp[p];
                if(min == val*prim){
                    pos[i] = pos[i]+1;
                }
            }
        }
        
        return dp[n];
        
    }
}
