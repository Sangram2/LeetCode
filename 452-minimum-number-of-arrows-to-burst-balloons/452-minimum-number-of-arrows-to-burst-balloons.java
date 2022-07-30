class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] > b[0]){
                return 1;
            } else if(a[0] == b[0]){
                return 0;
            } else {
                return -1;
            }
        });
        for(int[]f:points){
            System.out.println(f[0]+" "+f[1]);
        }
        int ans = 0;
        int end = 0;
        for(int i = 0;i<points.length;i++){
           if(i==0){
               ans++;
               end = points[i][1];
               continue;
               
           } else{
               int st = points[i][0];
               if(st<=end){
                   end = Math.min(end,points[i][1]);
               }
               else{
                   ans++;
                   end = Math.max(end,points[i][1]);
               }
               
           }
            
        }
        return ans;
    }
}