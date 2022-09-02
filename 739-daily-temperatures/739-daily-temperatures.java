class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1;i<temp.length;i++){
            while(st.size()!=0 && temp[i]>temp[st.peek()]){
                int idx = st.pop();
                ans[idx] = i-idx;
            }
            st.push(i);
        }
        return ans;
    }
}