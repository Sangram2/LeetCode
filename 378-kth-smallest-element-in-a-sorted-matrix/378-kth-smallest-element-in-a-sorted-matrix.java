class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int lo = matrix[0][0];
        int hi =matrix[m-1][n-1];
        
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            
            int count = 0;
            int j = n-1;
            for(int i =0;i<m;i++){
                while(j>=0 && matrix[i][j]>mid){
                    j--;
                }
                if(j==-1){
                    break;
                }
                count+=j+1;
            }
            
            if(count<k){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}

// class Solution {
//     class pair implements Comparable<pair>{
//         int r;
//         int c;
//         int val;
//         pair(int r,int c,int val){
//             this.r = r;
//             this.c = c;
//             this.val = val;
//         }
//         public int compareTo(pair o){
//             return this.val-o.val;
//         }
        
        
//     }
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<pair> pq = new PriorityQueue<>();
//         int n = matrix.length;
//         for(int i=0;i<matrix[0].length;i++){
//             pq.add(new pair(0,i,matrix[0][i]));
//         }
        
//         int f = 0;
//         int val = 0;
//         while(f<k){
//             pair rem = pq.remove();
//             f++;
//             val = rem.val;
//             if(rem.r<n-1){
//                 pq.add(new pair(rem.r+1,rem.c,matrix[rem.r+1][rem.c]));
//             }
//         }
//         return val;
//     }
// }