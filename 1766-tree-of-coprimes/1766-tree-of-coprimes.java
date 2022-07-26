class Solution {
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    static HashMap<Integer,HashSet<Integer>> hm;
    static int ans[];
    static Pair cal[];
    static ArrayList<ArrayList<Integer>> list;
    public int[] getCoprimes(int[] nums, int[][] edges) {
        hm = new HashMap<>();
        list = new ArrayList<>();
        int n = nums.length;
        ans = new int[n];
        cal = new Pair[51];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i =1;i<=50;i++){
            cal[i] = new Pair(-1,-1);
            HashSet<Integer> cp = new HashSet<>();
            for(int j = 1;j<=50;j++){
                if(gcd(i,j)==1)
                 cp.add(j);
            }
            hm.put(i,cp);
        }
        int m = edges.length;
        for(int i=0;i<m;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        Map<Integer,ArrayList<Pair>> map = new HashMap<>();
        dfs(0,-1,map,nums,0);
        return ans;
    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static void dfs(int node,int par,Map<Integer,ArrayList<Pair>> map,int a[],int c)
    {
        int cc = -1;
        int dp = -1;
        int aa = cal[a[node]].x;
        int bb = cal[a[node]].y;
            for(Integer x : hm.get(a[node])){
                Pair p = cal[x];
                if(p.y>dp){
                    dp = p.y;
                    cc = p.x;
                }
            }
        ans[node] = cc;
        cal[a[node]] = new Pair(node,c);
        for(Integer p : list.get(node)){
            if(p==par)
                continue;
            else{
                dfs(p,node,map,a,c+1);
            }
        }
        cal[a[node]] = new Pair(aa,bb);  
    }
}