// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] InDegree = new int[V];
        int[] ans = new int[V];
        
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                int vtx = adj.get(i).get(j);
                InDegree[vtx]++;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        
        for(int i=0;i<InDegree.length;i++){
            if(InDegree[i]==0){
                qu.add(i);
            }
        }
        int count = 0;
        while(qu.size()!=0){
            int rem = qu.remove();
            ans[count++] = rem;
            
            for(int nbr : adj.get(rem)){
                InDegree[nbr]--;
                if(InDegree[nbr]==0){
                    qu.add(nbr);
                }
            }
        }
        
        //This check tells about if there is a cycle or not...
        boolean isCyclePresent = false;
        if(count!=V){
            isCyclePresent = true;
        }
        
        return ans;
    }
}


//Sir  ka  code


// class Solution
// {
//     //Function to return list containing vertices in Topological order. 
//     static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
//     {
//         // add your code here
//         int[] tsort = new int[V];
        
//         int[] inDegree = new int[V];
//         for(int v = 0; v < V; v++){
//             for(int n: adj.get(v)){
//                 inDegree[n]++;
//             }
//         }
        
//         ArrayDeque<Integer> queue = new ArrayDeque<>();
//         for(int v = 0; v < V; v++){
//             if(inDegree[v] == 0){
//                 queue.add(v);
//             }
//         }
        
//         int idx = 0;
//         while(queue.size() > 0){
//             int v = queue.remove();
//             tsort[idx++] = v;
            
//             for(int n: adj.get(v)){
//                 inDegree[n]--;
//                 if(inDegree[n] == 0){
//                     queue.add(n);
//                 }
//             }
//         }
        
//         return tsort;
//     }
// }