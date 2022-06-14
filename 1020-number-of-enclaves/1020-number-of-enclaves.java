class Solution {
    class pair{
        int count=1;
        boolean check=true;
        
        pair(){
            
        }
        pair(int count,boolean check){
            this.count=count;
            this.check=check;
        }
    }
     static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    
    public pair marker(int[][] grid,int i,int j){
        if((i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)){
            return new pair(0,false);
        }
        grid[i][j]=0;
        pair rp=new pair();
        for(int k=0;k<dir.length;k++){
            int r=i+dir[k][0];
            int c=j+dir[k][1];
            
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length &&  grid[r][c]==1){
                pair p = marker(grid,r,c);
                if(p.check==false){
                    rp.check=false;
                    rp.count=0;
                    
                }
                else{
                    rp.count+=p.count;
                }
            }
            
        }
        ;
        return rp;
    }
        
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
              if(grid[i][j]==1){
                  
                  pair pans=marker(grid,i,j);
                  if(pans.check==true)
                    count+=pans.count;
              }  
            }
        }
        return count;
    }
}