class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] es = new int[n][2];
        for(int i = 0;i<n;i++){
            int[] ess = new int[]{efficiency[i],speed[i]};
            es[i] = ess;
        }
        
        Arrays.sort(es,(a,b)->{
            return b[0]-a[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long res = 0,mod = (long)1e9+7;
        long sumS = 0;
      
        for (int[] arr : es) {
            pq.add(arr[1]);
            sumS = (sumS + arr[1]);
            if (pq.size() > k) sumS -= pq.poll();
            res = Math.max(res, (sumS * arr[0]));
        }
        
        return (int)(res%mod);
    }
   
}