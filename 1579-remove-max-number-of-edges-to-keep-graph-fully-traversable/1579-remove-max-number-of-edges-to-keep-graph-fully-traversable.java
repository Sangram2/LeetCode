class Solution {
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parent = new int[n+1];
        int[] rank = new int[n+1]; 
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int e1 =0;
        int e2 = 0;
        int res = 0;
        
        for(int[]edge : edges){
            if(edge[0] == 3){
                boolean check = union(edge[1],edge[2],parent,rank);
                if(check){
                    e1++;
                    e2++;
                }
                else{
                    res++;
                }
            }
        }
        
        int[] p1 = parent.clone();
        int[] r1 = rank.clone();
        for(int[]edge : edges){
            if(edge[0] == 2){
                boolean check = union(edge[1],edge[2],p1,r1);
                if(check){
                    
                    e2++;
                }
                else{
                    res++;
                }
            }
        }
        
        int[] p2 = parent.clone();
        int[] r2 = rank.clone();
        for(int[]edge : edges){
            if(edge[0] == 1){
                boolean check = union(edge[1],edge[2],p2,r2);
                if(check){
                    e1++;
                   
                }
                else{
                    res++;
                }
            }
        }
    
        if(e1!=n-1 || e2!=n-1){
            return -1;
        }
        return res;
        
        
        
        
    }
    
    int find(int[] p,int x){
        if(p[x] == x){
            return x;
        }
        return p[x] = find(p,p[x]);
    }
    
    boolean union(int X,int Y,int[] p,int[] r){
        int x = find(p,X);
        int y = find(p,Y);
        
        if(x==y){
            return false;
        }else{
            if(r[x]>r[y]){
                p[y] = x;
            }
            else if(r[x]<r[y]){
                p[x] = y;
            }
            else{
                p[x] = y;
                r[y]++;
            }
            return true;
        }
    }
}