// class Solution {
//     public int[] findOrder(int N, int[][] preRq) {
//         if(N==1){
//             return new int[]{0};
//         }
        
//         int[] rtsort = new int[N];
//         int[] inDegree = new int[N];
//         ArrayList<Integer>[] graph = new ArrayList[N];
//         for(int i=0;i<N;i++){
//             graph[i] = new ArrayList<>();
//         }
        
//         for(int[] edge : preRq){
//             graph[edge[0]].add(edge[1]);
//             inDegree[edge[1]]++;
//         }
//         Queue<Integer> qu = new LinkedList<>();
//         for(int v=0;v<N;v++){
//             if(inDegree[v]==0){
//                 qu.add(v);
//             }
//         }
//         int idx=N-1;
//         while(qu.size()!=0){
//             int rem = qu.remove();
//             rtsort[idx--]=rem;
            
//             for(int nbr : graph[rem]){
//                 inDegree[nbr]--;
//                 if(inDegree[nbr]==0){
//                     qu.add(nbr);
//                 }
//             }
//         }
//         if(idx>=0){
//             return new int[]{};
//         }
        
//         return rtsort;
//     }
// }

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        
        int[] in = new int[numCourses];
        for(int[] edge: prerequisites){
            in[edge[1]]++;
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int course = 0; course < numCourses; course++){
            if(in[course] == 0){
                queue.add(course);
            }
        }
        
        int idx = ans.length - 1;
        while(queue.size() > 0){
            int course = queue.remove();
            ans[idx--] = course;
            
            for(int[] edge: prerequisites){
                if(edge[0] == course){
                    in[edge[1]]--;
                    
                    if(in[edge[1]] == 0){
                        queue.add(edge[1]);
                    }
                }
            }
        }
        
        if(idx != -1){
            return new int[]{};
        }
        
        return ans;
    }
}