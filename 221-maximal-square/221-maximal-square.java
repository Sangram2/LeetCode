class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] b = new int[m+1][n+1];
        int ans = 0;
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    b[i][j] = Math.min(b[i-1][j-1],Math.min(b[i-1][j],b[i][j-1])) + 1;
                    ans = Math.max(ans,b[i][j]);
                }
            }
        }
        
        return ans*ans; 
    }
}