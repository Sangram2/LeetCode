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
            distance=rem.dis;
            
            
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

// class Solution {
//     class Pair {
//         int i;
//         int j;
//         int level;
        
//         Pair(int i, int j, int level){
//             this.i = i;
//             this.j = j;
//             this.level = level;
//         }
//     }
    
//     public int maxDistance(int[][] grid) {
//         boolean[][] visited = new boolean[grid.length][grid[0].length];
//         ArrayDeque<Pair> queue = new ArrayDeque<>();
        
//         boolean noZero = true;
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] == 1){
//                     queue.add(new Pair(i, j, 0));
//                 } else {
//                     noZero = false;
//                 }
//             }
//         }
        
//         if(noZero){
//             return -1;
//         }
        
//         int dist = -1;
        
//         while(queue.size() > 0){
//             Pair rem = queue.remove();
            
//             if(visited[rem.i][rem.j] == true){
//                 continue;
//             }
//             visited[rem.i][rem.j] = true;
            
//             dist = Math.max(dist, rem.level);
            
//             addChild(grid, visited, queue, rem.i - 1, rem.j, rem.level + 1);
//             addChild(grid, visited, queue, rem.i + 1, rem.j, rem.level + 1);
//             addChild(grid, visited, queue, rem.i, rem.j - 1, rem.level + 1);
//             addChild(grid, visited, queue, rem.i, rem.j + 1, rem.level + 1);
//         }
        
//         return dist;
//     }
    
//     public void addChild(int[][] grid, boolean[][] visited, ArrayDeque<Pair> queue, int i, int j, int level){
//         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == 1){
//             return;
//         }
        
//         queue.add(new Pair(i, j, level));
//     }
// }