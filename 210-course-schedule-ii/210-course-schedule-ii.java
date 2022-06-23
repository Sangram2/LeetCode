class Solution {
    public int[] findOrder(int N, int[][] preRq) {
        if(N==1){
            return new int[]{0};
        }
        
        int[] rtsort = new int[N];
        int[] inDegree = new int[N];
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : preRq){
            graph[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int v=0;v<N;v++){
            if(inDegree[v]==0){
                qu.add(v);
            }
        }
        int idx=0;
        while(qu.size()!=0){
            int rem = qu.remove();
            rtsort[idx++]=rem;
            
            for(int nbr : graph[rem]){
                inDegree[nbr]--;
                if(inDegree[nbr]==0){
                    qu.add(nbr);
                }
            }
        }
        if(idx<N){
            return new int[]{};
        }
        
        int []ans = new int[N];
        for(int i=0;i<N;i++){
            ans[i]=rtsort[N-1-i];
        }
        return ans;
    }
}