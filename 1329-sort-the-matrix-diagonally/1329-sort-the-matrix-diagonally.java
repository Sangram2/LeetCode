class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer,PriorityQueue<Integer>> hm = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap = i-j;
                
                if(!hm.containsKey(gap)){
                    hm.put(gap,new PriorityQueue<>());
                }
                hm.get(gap).add(mat[i][j]);
                
                
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap = i-j;
                
                mat[i][j] = hm.get(gap).remove();
                
                
            }
        }
        return mat;
        
    }
}