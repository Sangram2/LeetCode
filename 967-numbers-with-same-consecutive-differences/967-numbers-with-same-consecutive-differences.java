class Solution {
    public int[] numsSameConsecDiff(int N, int k) {
        List<Integer> cur = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for(int i = 2;i<=N;i++){
            List<Integer> curr = new ArrayList<>();
            for(int x:cur){
                int y = x%10;
                if(y+k<10){
                    curr.add(10*x+ (y+k));
                }
                
                if(k>0 && y-k>=0){
                    curr.add(10*x+ (y-k));
                }
            }
            cur = curr;
        }
        
        int[] ans = new int[cur.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = cur.get(i);
        }
        
        return ans;
    }
}