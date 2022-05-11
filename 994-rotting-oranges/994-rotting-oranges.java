class Solution {
    public int[][] dir= {{1,0},{0,-1},{-1,0},{0,1}};
    public class pair{
        int x;
        int y;
        pair(){};
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid){
        Queue<pair> qu=new LinkedList<>();
        boolean check=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    qu.add(new pair(i,j));
                }
                if(grid[i][j]==1){
                    check=true;
                }
            }
        }
        if(check==false){
           return 0; 
        }
            
        
        int t=-1;
        while(qu.size()!=0){
            int size=qu.size();
            while(size-->0){
                pair rem=qu.remove();
                for(int []d : dir){
                    int h=d[0]+rem.x;
                    int k=d[1]+rem.y;
                    if(h>=0 && h<grid.length && k>=0 && k<grid[0].length && grid[h][k]==1){
                        grid[h][k]=2;
                        qu.add(new pair(h,k));
                    }
                }
            }
            t++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return t;

    }
}