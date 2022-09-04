class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int a:asteroids){
            if(a>0){
                st.push(a);
            }
            else{
                while(st.size()>0 && st.peek()<Math.abs(a) && st.peek()>0){
                    st.pop();
                }
                if(st.size()>0 && st.peek()==Math.abs(a) && st.peek()>0){
                    st.pop();
                }
                else if(st.size()>0 && st.peek()<0){
                    st.push(a);
                }
                else if(st.size()>0 && st.peek()>Math.abs(a)){
                    continue;
                }
                else{
                    st.push(a);
                }
                
            }
        }
        
        int[] ans = new int[st.size()];
        int idx = st.size()-1;
        while(st.size()>0){
            ans[idx--] = st.pop();
        }
        
        return ans;
    }
}