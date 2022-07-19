class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max_ele = Integer.MIN_VALUE;
        int nmc = -1;
        int ans = 0;
        for(int ele:arr){
            
            if(ele>max_ele){
                max_ele = ele;
                nmc++;
            }
            else if(ele<max_ele){
                nmc++;
            }
            
            if(max_ele==nmc){
                ans++;
            }
        }
            
        
        
        return ans;
    }
}