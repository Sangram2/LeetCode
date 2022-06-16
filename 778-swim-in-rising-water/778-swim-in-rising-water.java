






class Solution {
    class Pair implements Comparable<Pair> {
        int i;
        int j;
        int cost;
        
        Pair(int i, int j, int cost){
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
        
        public int compareTo(Pair o){
            return this.cost - o.cost;
        }
    }
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1){
                return rem.cost;
            }
             for(int k=0;k<dir.length;k++){
                int r= dir[k][0]+rem.i;
                int c= dir[k][1]+rem.j;
                
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && visited[r][c]==false){
                    int time = Math.max(rem.cost,grid[r][c]);
                    pq.add(new Pair(r,c,time));
                }
            }
            
            
            
        }
        
        return -1;
    }
    
   
}