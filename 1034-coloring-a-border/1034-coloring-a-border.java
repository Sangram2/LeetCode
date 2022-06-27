//BFS

// class Solution {
//     class pair{
//         int x;
//         int y;
//         boolean border;
//         pair(int x,int y){
//             this.x=x;
//             this.y=y;
//         }
//     }
//     static int[][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
//     public int[][] colorBorder(int[][] grid, int row, int col, int color) {
//         int m=grid.length;
//         int n = grid[0].length;
//         if(m==0 || n==0){
//             return new int[m][n];
//         }
//         int oriCol=grid[row][col];
        
//         Queue<pair> qu = new LinkedList<>();
//         ArrayList<pair> res = new ArrayList<>();
//         boolean [][]vis = new boolean[m][n];
//         pair p = new pair(row,col);
//         p.border = isBorder(grid,row,col);
//         qu.add(p);
        
//         while(qu.size()!=0){
//             pair rem = qu.remove();
//             if(vis[rem.x][rem.y]==true){
//                 continue;
//             }
//             vis[rem.x][rem.y]=true;
//             if(rem.border){
//                 res.add(rem);
//             }
            
//             for(int i=0;i<dir.length;i++){
//                 int r = rem.x+dir[i][0];
//                 int c = rem.y+dir[i][1];
                
//                 if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==oriCol && vis[r][c]==false){
//                     pair d = new pair(r,c);
//                     d.border = isBorder(grid,r,c);
//                     qu.add(d);
//                 }
//             }
//         }
//         for(pair c:res){
//             grid[c.x][c.y]=color;
//         }
//         return grid;
//     }
    
//     public boolean isBorder(int[][] grid, int row, int col){
//         if(row==0 || row==grid.length-1 || col==0 || col==grid[0].length-1){
//             return true;
//         }
//         int yourCol = grid[row][col];
//         for(int i=0;i<dir.length;i++){
//             int r=dir[i][0]+row;
//             int c= dir[i][1]+col;
            
//             if(grid[r][c]!=yourCol){
//                 return true;
//             }
            
//         }
//         return false;
//     }
// }

// BFS
class Solution {
    class Pair {
        int i;
        int j;
        boolean border;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        Pair p = new Pair(row, col);
        p.border = isBorder(grid, row, col);
        queue.add(p);
        
        ArrayList<Pair> res = new ArrayList<>();
        int orgc = grid[row][col];
        
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(visited[rem.i][rem.j]){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            if(rem.border){
                res.add(rem);
            }
            
            addN(grid, visited, queue, orgc, rem.i - 1, rem.j);
            addN(grid, visited, queue, orgc, rem.i + 1, rem.j);
            addN(grid, visited, queue, orgc, rem.i, rem.j - 1);
            addN(grid, visited, queue, orgc, rem.i, rem.j + 1);
        }
        
        for(Pair pair: res){
            grid[pair.i][pair.j] = color;
        }
        
        return grid;
    }
    
    public void addN(int[][] grid, boolean[][] visited, ArrayDeque<Pair> queue, int orgc, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] != orgc){
            return;
        }
        
        Pair p = new Pair(i, j);
        p.border = isBorder(grid, i, j);
        queue.add(p);
    }
    
    
    public boolean isBorder(int[][] grid, int i, int j){
        if(i == 0){
            return true;
        } else if(i == grid.length - 1){
            return true;
        } else if(j == 0){
            return true;
        } else if(j == grid[0].length - 1){
            return true;
        } else {
            int color = grid[i][j];
            if(grid[i - 1][j] != color){
                return true;
            } else if(grid[i + 1][j] != color){
                return true;
            } else if(grid[i][j - 1] != color){
                return true;
            } else if(grid[i][j + 1] != color){
                return true;
            } else {
                return false;
            }
        }
    }
}




//  DFS
// class Solution {
//     public int[][] colorBorder(int[][] grid, int row, int col, int color) {
//         int oc = grid[row][col];
//         traverse(grid, row, col, oc);
        
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] == -oc){
//                     grid[i][j] = color;
//                 }
//             }
//         }
        
//         return grid;
//     }
    
//     public void traverse(int[][] grid, int i, int j, int oc){
//         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oc){
//             return;
//         }
        
//         grid[i][j] = -oc;
        
//         traverse(grid, i - 1, j, oc);
//         traverse(grid, i + 1, j, oc);
//         traverse(grid, i, j - 1, oc);
//         traverse(grid, i, j + 1, oc);
        
//         if(i > 0 && j > 0 && i < grid.length - 1 && j < grid[0].length - 1 &&
//            Math.abs(grid[i - 1][j]) == oc &&
//            Math.abs(grid[i + 1][j]) == oc &&
//            Math.abs(grid[i][j - 1]) == oc &&
//            Math.abs(grid[i][j + 1]) == oc){
//             grid[i][j] = oc;
//         }
//     }
// }
