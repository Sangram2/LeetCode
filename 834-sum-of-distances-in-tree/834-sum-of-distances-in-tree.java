class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        HashSet<Integer>[] graph = new HashSet[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new HashSet<>();
        }
        
        for(int i=0;i<n-1;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] node = new int[n];
        int[] res = new int[n];
        helper1(graph,node,res,0,-1);
        helper2(graph,node,res,0,-1);
        return res;
    }
    public void helper1(HashSet<Integer>[] graph, int[] nodes, int[] res, int src, int par){
        for(int nbr: graph[src]){
            if(nbr != par){
                helper1(graph, nodes, res, nbr, src);
                nodes[src] += nodes[nbr];
                res[src] += nodes[nbr] + res[nbr];
            }
        }

        nodes[src]++;
    }
    public void helper2(HashSet<Integer>[] graph,int[] node,int[] res,int src,int p){
        for(int nbr:graph[src]){
            if(nbr!=p){
                res[nbr]=res[src]-node[nbr]+(node.length-node[nbr]);
                helper2(graph,node,res,nbr,src);
            }
            
        }
    }
}