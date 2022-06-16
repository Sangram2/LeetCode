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
    public int maxDistance(int[][] mat) {
        boolean [][]vis =new boolean[mat.length][mat[0].length];
        int count=0;
        Queue<pair> qu = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    qu.add(new pair(i,j,0));
                }
                else{
                    count++;
                }
                
            }
        }
        int distance=-1;
        if(qu.size()==0 || count==0){
            return -1;
        }
        while(qu.size()!=0){
            pair rem=qu.remove();
            if(vis[rem.x][rem.y]!=false){
                continue;
            }
            vis[rem.x][rem.y]=true;
            distance=Math.max(distance,rem.dis);
            
            
            for(int i=0;i<dir.length;i++){
                int r=rem.x+dir[i][0];
                int c= rem.y+dir[i][1];
                
                if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && vis[r][c]==false && mat[r][c]==0){
                    qu.add(new pair(r,c,rem.dis+1));
                }
            }
            
        }
        return distance;
    }
}