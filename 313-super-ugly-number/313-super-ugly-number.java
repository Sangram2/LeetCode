// class Solution {
// //     public int nthSuperUglyNumber(int n, int[] primes) {
// //         PriorityQueue<Integer> pq = new PriorityQueue<>();
// //         HashSet<Integer> hs = new HashSet<>();
// //         pq.add(1);
// //         int st = 1;
// //         while(n-->0){
// //             st = pq.remove();
            
// //             for(int p:primes){
// //                 if(hs.contains(st*p)){
// //                     continue;
// //                 }
// //                 pq.add(st*p);
// //                 hs.add(st*p);
// //             }
// //         }
// //         return st;
// //     }
//     public int nthSuperUglyNumber(int n, int[] primes) {
//         int[] pos = new int[primes.length];
//         Arrays.fill(pos,1);
//         int[] dp =new int[n+1];
//         dp[1] = 1;
//         for(int j = 2;j <= n; j++){
//             long min = Long.MAX_VALUE;
//             for(int i = 0;i<pos.length;i++){
//                 int p = pos[i];
//                 int prim = primes[i];
//                 int val = dp[p];
//                 min = Math.min((long)min,(long)val*prim);
//             }
//             dp[j] = (int)min;
//             for(int i = 0;i<pos.length;i++){
//                 int p = pos[i];
//                 int prim = primes[i];
//                 int val = dp[p];
//                 if(min == val*prim){
//                     pos[i] = pos[i]+1;
//                 }
//             }
//         }
        
//         return dp[n];
        
//     }
// }
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        
        int[] idxs = new int[primes.length];
        Arrays.fill(idxs, 1);
        
        for(int i = 2; i < dp.length; i++){
            long ans = Long.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = idxs[j];
                
                ans = Math.min(ans, dp[idx] * prime);
            }
            
            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = idxs[j];
                
                if(ans == dp[idx] * prime){
                    idxs[j] = idx + 1;
                }
            }
            
            dp[i] = ans;
        }
        
        return (int)dp[n];
    }
}