class Solution {
//     public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
//         int[][] es = new int[n][2];
//         for(int i = 0;i<n;i++){
//             int[] ess = new int[]{efficiency[i],speed[i]};
//             es[i] = ess;
//         }
        
//         Arrays.sort(es,(a,b)->{
//             return b[0]-a[0];
//         });
//         PriorityQueue<Integer> pq = new PriorityQueue<>(k);
//         long max = 0,mod = (long)1e9+7;
//         long sum = 0;
//         for(int[] arr:es){
//             sum=(sum+arr[1])%mod;
//             pq.add(arr[1]);
//             if(pq.size()>k){
//                 sum =(sum-pq.remove())%mod;
                
//             }
//             max = (long)Math.max((arr[0]*sum)%mod,max);
//         }
//         return (int)(max%mod);
//     }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i)
            ess[i] = new int[] {efficiency[i], speed[i]};
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) sumS -= pq.poll();
            res = Math.max(res, (sumS * es[0]));
        }
        return (int) (res % (long)(1e9 + 7));
    }
}