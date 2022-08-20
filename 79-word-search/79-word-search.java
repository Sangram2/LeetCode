class Solution {
    
    int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(word.length()>m*n){
            return false;
        }
        char st = word.charAt(0);
        List<List<Integer>> c = new ArrayList<>();
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == st){
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    c.add(li);
                }
            }
        }
        boolean[][] vis = new boolean[m][n];
        for(List<Integer> k:c){
            int x = k.get(0);
            int y = k.get(1);
            vis[x][y] = true;
            
            boolean  check = dfs(x,y,vis,word,board,0);
            if(check){
                return true;
            }
            vis[x][y] = false;
        }
        return false;
    }
    
    boolean dfs(int x,int y,boolean[][] vis,String word,char[][] board,int pos){
        if(board[x][y] == word.charAt(pos) && pos==word.length()-1){
            return true;
        }
        if(board[x][y] != word.charAt(pos)){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        // vis[x][y] = true;
        
        for(int[] d:dir){
            int r = x+d[0];
            int c = y+d[1];
            
            if(r>=0 && c>=0 && r<m && c<n && vis[r][c]==false && (board[r][c]==word.charAt(pos+1))){
                vis[r][c] = true;
                boolean v = dfs(r,c,vis,word,board,pos+1);
                if(v){
                    return true;
                }
                vis[r][c] = false;
                
            }
           
        }
        return false;
    }
}