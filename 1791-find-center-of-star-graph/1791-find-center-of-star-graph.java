class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        int[] count = new int[n];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            count[u-1]++;
            count[v-1]++;
        }
        for(int i = 0;i<n;i++){
            if(count[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}