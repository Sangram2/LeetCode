class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        int[] indg = new int[n];
        
        for(int[] edge : pre){
            graph[edge[0]].add(edge[1]);
            indg[edge[1]]++;
            
        } 
        
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indg[i]==0){
                qu.add(i);
            }
        }
        int c = 0;
        while(qu.size()!=0){
            int rem = qu.remove();
            c++;
            for(int nbr : graph[rem]){
                indg[nbr]--;
                if(indg[nbr]==0){
                    qu.add(nbr);
                }
            }
        }
        if(c==n){
            return true;
        }
        else{
            return false;
        }
        
    }
}