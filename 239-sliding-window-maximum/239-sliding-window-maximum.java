// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int[] ngtr = find(nums);
        
//         int[] res = new int[nums.length-k+1];
//         int idx = 0;
         
//         for(int i = 0;i+k<=nums.length;i++){
//             int itr = i;
//             int ans = 0; 
//             while(itr<i+k){
//                 ans = nums[itr];
                
//                 itr = ngtr[itr];
//             }
          
//             res[idx++] = ans;
//         } 
        
//        return res;
        
        
//     }
    
//     public int[] find(int[] nums){
//         Stack<Integer> st = new Stack<>();
//         int[] ngtr = new int[nums.length];
//         st.push(0);
//         for(int i=1;i<nums.length;i++){
//             while(st.size()!=0 && nums[i]>nums[st.peek()]){
//                 int idx = st.pop();
//                 ngtr[idx] = i;
//             }
//             st.push(i);
//         }
        
//         while(st.size()!=0){
//             ngtr[st.pop()] = nums.length+1;
//         }
        
//         return ngtr;
//     }
// }
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        
        st.push(nums.length - 1);
        nge[nums.length - 1] = nums.length;
        
        for(int i = nums.length - 2; i >= 0; i--){
            int val = nums[i];
            while(st.size() > 0 && val >= nums[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                nge[i] = nums.length;
            } else {
                nge[i] = st.peek();
            }
            
            st.push(i);
        }
        
        
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for(int i = 0; i < res.length; i++){
            if(j < i){
                j = i;
            }
            
            while(nge[j] <= i + k - 1){
                j = nge[j];
            }
            
            res[i] = nums[j];
        }
     
        return res;
    }
}