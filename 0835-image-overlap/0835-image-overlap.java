class Solution {
    static boolean vis[][];
    static int n;
    static int ans;
    public int largestOverlap(int[][] img1, int[][] img2) {
        ans = 0;
        n = img1.length;
        vis = new boolean[2*n+1][2*n+1];
        check(img1,img2,n,n);
        return ans;
        
    }
    static void check(int[][] img1, int[][] img2,int r,int c){
        if(vis[r][c])
            return;
        vis[r][c] = true;
        if(r+1<2*n)
        check(img1,img2,r+1,c);
        if(c+1<2*n)
        check(img1,img2,r,c+1);
        if(r-1>=0)
        check(img1,img2,r-1,c);
        if(c-1>=0)
        check(img1,img2,r,c-1);
        int co = 0;
        for(int i = 0;i<(n);i++){
            for(int j = 0;j<(n);j++){
                int x = r-n;
                int y = c-n;
                if(x>=0 && y>=0  && (i+x)<n &&(j+y)<n){
                if(img1[i][j]==img2[x+i][y+j] && img1[i][j]==1){
                    co+=1;
                }
                }
                if(x>=0 && y<0  && (i+x)<n &&(j-y)<n){
                if(img1[i][j-y]==img2[x+i][j] && img1[i][j-y]==1){
                    co+=1;
                }
                }
                if(x<0 && y>=0 && (i-x)<n &&(j+y)<n){
                if(img1[i-x][j]==img2[i][j+y] && img1[i-x][j]==1){
                    co+=1;
                }
                }
                if(x<0 && y<0 && (i-x)<n &&(j-y)<n){
                if(img1[i-x][j-y]==img2[i][j] && img1[i-x][j-y]==1){
                    co+=1;
                }
                }
            }
        }
        ans = Math.max(ans,co);
    }
}