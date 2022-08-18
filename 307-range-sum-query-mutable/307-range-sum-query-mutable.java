class NumArray {
    Node root;
    class Node{
        int str,end;
        Node left,right;
        int val;
    }
    public Node construct(int[] nums,int lo,int hi){
        if(lo==hi){
            Node node = new Node();
            node.str = node.end = lo;
            node.left = node.right = null;
            node.val = nums[lo];
            return node;
        }
        
        
        Node node = new Node();
        node.str = lo;
        node.end = hi;
        int mid = (lo + hi)/2;
        node.left = construct(nums,lo,mid);
        node.right = construct(nums,mid+1,hi);
        
        node.val = node.left.val+node.right.val;
        return node;
        
    }
    public NumArray(int[] nums) {
        root = construct(nums,0,nums.length-1);
    }
    
    
    void update(Node node,int idx,int value){
        int lo = node.str;
        int hi = node.end;
        int mid = (lo+hi)/2;
        if(lo==hi){
            node.val = value;
            return;
        }
        
        
        
        if(idx<=mid){
            update(node.left,idx,value);
        }
        else{
            update(node.right,idx,value);
        }
        
        node.val=node.left.val+node.right.val;
        
        
    }
    
    public void update(int index, int val) {
        update(root,index,val);
    }
    
    int query(Node node,int left,int right){
        if(node.str>right || node.end<left){
            return 0;
        }
        if(node.str>=left && node.end<=right){
            return node.val;
        }
        
        return query(node.left,left,right)+query(node.right,left,right);
    }
    
    public int sumRange(int left, int right) {
        int sum = query(root,left,right);
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */