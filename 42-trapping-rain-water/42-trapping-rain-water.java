class Solution {
    public int trap(int[] height) {
        //you cannot use Integer.MIN_VALUE to initialize l_max,r_max and if you do so then there will be a int overflow at line 12 and 18.
        int l_max=0;  
        int r_max=0;
        int n=height.length;
        int low=0,high=n-1;
        int aow=0;
        
        while(low<=high){
            if(l_max<=r_max){
                aow+=Math.max(0,l_max-height[low]);
                l_max=Math.max(l_max,height[low]);
                low++;
                
            }
            else{
                aow+=Math.max(0,r_max-height[high]);
                r_max=Math.max(r_max,height[high]);
                high--;
            }
        }
        return aow;
    }
}