// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         Arrays.sort(points, (a, b) -> {
//             if(a[0] > b[0]){
//                 return 1;
//             } else if(a[0] == b[0]){
//                 return 0;
//             } else {
//                 return -1;
//             }
//         });
        
//         int ans = 0;
//         int end = 0;
//         for(int i = 0;i<points.length;i++){
//            if(i==0){
//                ans++;
//                end = points[i][1];
//                continue;
               
//            } else{
//                int st = points[i][0];
//                if(st<=end){
//                    end = Math.min(end,points[i][1]);
//                }
//                else{
//                    ans++;
//                    end = points[i][1];
//                }
               
//            }
            
//         }
//         return ans;
//     }
// }
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
        
        int count = 0;
        int end = Integer.MAX_VALUE;
        for(int[] p: points){
            if(p[0] > end){
                count++;
                end = p[1];
            } else {
                end = Math.min(end, p[1]);
            }
        }
        
        return count + 1;
    }
}