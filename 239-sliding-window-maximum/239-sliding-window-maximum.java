class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ngtr = find(nums);
        
        int[] res = new int[nums.length-k+1];
        int idx = 0;
         
        for(int i = 0;i+k<=nums.length;i++){
            int itr = i;
            int ans = 0; 
            while(itr<i+k){
                ans = nums[itr];
                
                itr = ngtr[itr];
            }
          
            res[idx++] = ans;
        } 
        
       return res;
        
        
    }
    
    public int[] find(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ngtr = new int[nums.length];
        st.push(0);
        for(int i=1;i<nums.length;i++){
            while(st.size()!=0 && nums[i]>nums[st.peek()]){
                int idx = st.pop();
                ngtr[idx] = i;
            }
            st.push(i);
        }
        
        while(st.size()!=0){
            ngtr[st.pop()] = nums.length+1;
        }
        
        return ngtr;
    }
}