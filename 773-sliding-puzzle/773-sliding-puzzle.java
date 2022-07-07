class Solution {
    class pair{
        String config;
        int swaps;
        pair(String config,int swaps){
            this.config = config;
            this.swaps = swaps;
        }
    }
    public int slidingPuzzle(int[][] board) {
        String dest = "123450"; 
        HashSet<String> vis = new HashSet<>();
        Queue<pair> qu = new LinkedList<>();
        String iniConfig = getBoardConfig(board);
        qu.add(new pair(iniConfig,0));
        
        int[][] dir = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        while(qu.size()!=0){
            pair rem = qu.remove();
            
            if(vis.contains(rem.config)){
                continue;
            }
            vis.add(rem.config);
            
            if(rem.config.equals(dest)){
                return rem.swaps;
            }
            int idx0 = rem.config.indexOf('0');
            for(int j : dir[idx0]){
                String newConfig = swap(rem.config,idx0,j);
                if(!vis.contains(newConfig)){
                    qu.add(new pair(newConfig,rem.swaps+1));
                }   
            } 
        }
        return -1;
        
    }
    String swap(String str, int i,int j){
        StringBuilder s = new StringBuilder(str);
        
        char chi= s.charAt(i);
        char chj = s.charAt(j);
        
        s.setCharAt(j,chi);
        s.setCharAt(i,chj);
        
        return s.toString();
    }
    
    
    String getBoardConfig(int[][] board){
        StringBuilder s = new StringBuilder();
        for(int[] rows : board){
            for(int val : rows){
                s.append(val);
            }
        }
        return s.toString();   
    }
}