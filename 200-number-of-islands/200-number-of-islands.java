// class Solution {
//     static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    
//     public void marker(char[][] grid,int i,int j){
//         grid[i][j]='0';
//         for(int k=0;k<dir.length;k++){
//             int r=i+dir[k][0];
//             int c=j+dir[k][1];
//             if(r>=0 && r<grid.length && c>=0 && c<grid[0].length &&  grid[r][c]=='1'){
//                 marker(grid,r,c);
//             }
//         }
//     }
//     public int numIslands(char[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//               if(grid[i][j]=='1'){
//                   count++;
//                   marker(grid,i,j);
//               }  
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    count++;
                    traverse(grid, visited, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void traverse(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        } else if(grid[i][j] == '0'){
            return;
        } else if(visited[i][j] == true){
            return;
        }
        
        visited[i][j] = true;
        traverse(grid, visited, i - 1, j);
        traverse(grid, visited, i + 1, j);
        traverse(grid, visited, i, j - 1);
        traverse(grid, visited, i, j + 1);
    }
}