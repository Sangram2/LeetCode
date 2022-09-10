class FreqStack {
    int maxf = 0;
    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> help;
    
    public FreqStack() {
        maxf = 0;
        freq = new HashMap<>();
        help = new HashMap<>();
    }
    
    public void push(int val) {
        int fre = freq.getOrDefault(val, 0) + 1;
        freq.put(val, fre);
        maxf = Math.max(maxf, fre);
        
        if(!help.containsKey(maxf)){
            help.put(maxf, new Stack<>());
        }
        help.get(fre).push(val);
    }
    
    public int pop() {
        int ans = 0;
        if(help.get(maxf).size()>0)
            ans = help.get(maxf).pop();
        
        freq.put(ans,freq.get(ans)-1);
        if(help.get(maxf).size()==0){
            maxf--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */