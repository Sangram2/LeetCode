class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<Integer> pc = new ArrayList<>();
        int[][] sp = new int[n][n];
        for(int[] arr:trust){
            int p = arr[0];
            int j = arr[1];
            
            sp[p-1][j-1] = 1;
        }
        for(int i = 0;i<n;i++){
            boolean can = true;
            for(int j = 0;j<n;j++){
                if(sp[i][j] == 1){
                    can = false;
                    break;
                }
            }
            if(can){
                pc.add(i);
            }
        }
        
        for(int fc:pc){
            int sum = 0;
            for(int i = 0;i<n;i++){
                sum += sp[i][fc];
            }
            if(sum == n-1){
                return fc+1;
            }
        }
        
        return -1;
    }
}