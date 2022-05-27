/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {
//     public class pair{
//         int vl;
//         int hl;
//         TreeNode node;
//         pair(int vl,int hl,TreeNode node){
//             this.vl=vl;
//             this.hl=hl;
//             this.node = node;
//         }
//     } 
//     public class pair1{
//         int hl;
//         int node;
        
//         pair1(int hl,int node){
//             this.hl=hl;
//             this.node=node;
//         }
//     }
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>>ans= new ArrayList<>();
//         HashMap<Integer,PriorityQueue<pair1>> hm = new HashMap<>();
//         Queue<pair> qu = new LinkedList<>();
//         int rv=Integer.MIN_VALUE;
//         int lv=Integer.MAX_VALUE;
        
//         qu.add(new pair(0,0,root));
        
//         while(qu.size()!=0){
//             pair rem=qu.remove();
//             rv=Math.max(rv,rem.vl);
//             lv=Math.min(lv,rem.vl);
//             if(hm.containsKey(rem.vl)){
//                 PriorityQueue<pair1> d = hm.get(rem.vl);
//                 d.add(new pair1(rem.hl,rem.node.val));
//                 hm.put(rem.vl,d);
//             }
//             else{
//                 PriorityQueue<pair1> d = new PriorityQueue<>((a,b)->{
//                     if(a.hl!=b.hl){
//                         return a.hl-b.hl;
//                     }else{
//                         return a.node-b.node;
//                     }
//                 });
                    
//                 d.add(new pair1(rem.hl,rem.node.val));
//                 hm.put(rem.vl,d);
//             }
            
//             if(rem.node.left!=null){
//                 qu.add(new pair(rem.vl-1,rem.hl+1,rem.node.left));
//             }
//             if(rem.node.right!=null){
//                 qu.add(new pair(rem.vl+1,rem.hl+1,rem.node.right));
//             }
//         }
        
//         for(int i=lv;i<=rv;i++){
//             PriorityQueue<pair1> d = hm.get(i);
//             ArrayList<Integer> pans=new ArrayList<>();
//             while(d.size()!=0){
//                 pair1 h = d.remove();
//                 pans.add(h.node);
//             }
//             ans.add(pans);
//         }
//         return ans;
        
//     }
// }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int w;
        int d;

        Pair(TreeNode node, int w, int d){
            this.node = node;
            this.w = w;
            this.d = d;
        }

        // this - other means increasing
        // other - this means decreasing
        public int compareTo(Pair other){
            if(this.d == other.d){
                return this.node.val - other.node.val;
            } else {
                return this.d - other.d;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 1));

        int lmw = 0;
        int rmw = 0;
        
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        while(queue.size() > 0){
            Pair temp = queue.remove();

            if(temp.w < lmw){
                lmw = temp.w;
            }

            if(temp.w > rmw){
                rmw = temp.w;
            }

            if(map.containsKey(temp.w) == false){
                map.put(temp.w, new ArrayList<>());
                map.get(temp.w).add(temp);
            } else {
                map.get(temp.w).add(temp); 
            }

            if(temp.node.left != null){
                queue.add(new Pair(temp.node.left, temp.w - 1, temp.d + 1));
            }

            if(temp.node.right != null){
                queue.add(new Pair(temp.node.right, temp.w + 1, temp.d + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int w = lmw; w <= rmw; w++){
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Pair> unsortedList = map.get(w);
            Collections.sort(unsortedList);

            for(Pair temp: unsortedList){
                list.add(temp.node.val);
            }


            res.add(list);
        }
        

        return res;
    }
}