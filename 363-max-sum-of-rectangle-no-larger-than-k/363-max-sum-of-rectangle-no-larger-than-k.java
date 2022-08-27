class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int r1 = 0;r1<m;r1++){
            int[] arr = new int[n];
            for(int r2= r1;r2<m;r2++){
                for(int c= 0;c<n;c++){
                    arr[c] += matrix[r2][c];
                    
                }
                ans =Math.max(ans,solvefor1D(arr,k));
            }
        }
        return ans;
    }
    
    int solvefor1D(int[] arr,int k){
        int ps = 0;
        int ans = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for(int i = 0;i<arr.length;i++){
            ps += arr[i];
            
            Integer sub = set.ceiling(ps-k);
            if(sub!=null){
                ans = Math.max(ans,ps-sub);
            }
            set.add(ps);
        }
        return ans;
    }
}