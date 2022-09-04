class Solution {
//     int count = 0;
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//         ArrayList<Integer>[] graph = new ArrayList[n];
//         for(int i = 0;i<n;i++){
//             graph[i] = new ArrayList<>();
//         }
        
//         for(int[] edge:edges){
//             int u = edge[0];
//             int v = edge[1];
//             graph[u].add(v);
//             graph[v].add(u);
//         }
        
//         int[] height = new int[n];
//         for(int i =0 ;i<n;i++){
//             bfs(i,graph);
//             height[i] = count;
//             count = 0;
//         }
        
//         List<Integer> ans = new ArrayList<>();
//         int min = Integer.MAX_VALUE;
//         for(int val:height){
//             min = Math.min(min,val);
//         }
        
//         for(int a = 0;a<height.length;a++){
//             if(height[a] == min){
//                 ans.add(a);
//             }
//         }
        
//         return ans;
//     }
    
//     void bfs(int node,ArrayList<Integer>[] graph){
//         Queue<Integer> qu = new LinkedList<>();
//         qu.add(node);
//         boolean[] vis = new boolean[graph.length];
//         vis[node] = true;
//         while(qu.size()>0){
//             int size = qu.size();
//             while(size-->0){
//                 int rem = qu.remove();
//                 vis[rem] = true;
//                 for(int i: graph[rem]){
//                     if(!vis[i])
//                         qu.add(i);
//                 }
//             }
//             count++;
//         }
//     }

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        List<List<Integer>> adj = new ArrayList<>();
        int[] inlinks = new int[n];
        createGraph(n, edges, adj, inlinks);

        List<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < inlinks.length; i++) {
            if (inlinks[i] == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                for (int nb : adj.get(leave)) {
                    inlinks[nb]--;
                    if (inlinks[nb] == 1) {
                        newLeaves.add(nb);
                    }
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }

        return leaves;
    }

    public void createGraph(int n, int[][] edges, List<List<Integer>> adj, int[] inlinks) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            inlinks[e[0]]++;
            inlinks[e[1]]++;
        }
    }
 }

