class Solution {
    class pair{
        int x;
        int y;
        int dis;
        pair(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        
        int [][]ans =new int[mat.length][mat[0].length];
        boolean [][]vis =new boolean[mat.length][mat[0].length];
        
        Queue<pair> qu = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    qu.add(new pair(i,j,0));
                }
            }
        }
        
        while(qu.size()!=0){
            pair rem=qu.remove();
            if(vis[rem.x][rem.y]==true){
                continue;
            }
            vis[rem.x][rem.y]=true;
            ans[rem.x][rem.y]=rem.dis;
            
            for(int i=0;i<dir.length;i++){
                int r=rem.x+dir[i][0];
                int c= rem.y+dir[i][1];
                
                if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && vis[r][c]==false && mat[r][c]==1){
                    qu.add(new pair(r,c,rem.dis+1));
                }
            }
            
        }
        return ans;
    }
}

