// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals,(a,b)->{
//             return a[0]-b[0];
//         });
//         Stack<int []> st=new Stack<>();
//         st.push(intervals[0]);
//         for(int i=1;i<intervals.length;i++){
//             int []d=st.pop();
//             int []curr=intervals[i];
//             int s1=d[0];
//             int e1=d[1];
//             int s2=curr[0];
//             int e2=curr[1];
//             if(e1>=s2){
//                 int em=Math.max(e1,e2);
//                 st.push(new int[]{s1,em});
//             }
//             else{
//                 st.push(d);
//                 st.push(curr);
//             }
            
//         }
//         int [][]ans= new int[st.size()][2];
        
//         for(int i=ans.length-1;i>=0;i--){
//             ans[i]=st.pop();
//         }
//         return ans;
//     }
// }

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> {
            return a[0] - b[0];
        });
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] interval: intervals){
            if(list.size() == 0){
                list.add(interval);
            } else {
                int[] last = list.get(list.size() - 1);
                if(interval[0] > last[1]){
                    list.add(interval);
                } else {
                    last[1] = Math.max(last[1], interval[1]);
                }
            }
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}