class Solution {
    int[] count;
    class pair{
        int idx;
        int val;
        
        pair(int idx,int val){
            this.idx = idx;
            this.val = val;
        }
    }
    
    pair[] mergeSort(pair[] arr,int st,int en){
        if(st==en){
            pair[] p = new pair[1];
            p[0] = arr[st];
            return p;
        }
        int mid = (st+en)/2;
        pair[] lp = mergeSort(arr,st,mid);
        pair[] rp = mergeSort(arr,mid+1,en);
        
        pair[] sa = merge(lp,rp);
        return sa;
    }
    
    pair[] merge(pair[] lp,pair[] rp){
        int i =0;int j = 0;
        int k = 0;
        pair[] ans = new pair[lp.length+rp.length];
        while(i<lp.length && j<rp.length){
            if(lp[i].val>rp[j].val){
               ans[k] = lp[i];
                count[lp[i].idx] += rp.length-j; 
                k++;
                i++;
                
            }
            else{
                ans[k] = rp[j];
                k++;
                j++;
            }
        }
        while(i<lp.length){
           ans[k] = lp[i];
            
            k++;
            i++;
        }
        while(j<rp.length){ 
            ans[k] = rp[j];
            k++;
            j++;  
        }
        return ans;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        pair[] arr = new pair[nums.length];
        for(int i = 0;i<nums.length;i++){
            arr[i] = new pair(i,nums[i]);
        }
        
        mergeSort(arr,0,arr.length-1);
        List<Integer> ret = new ArrayList<>();
        
        for(int ele:count){
            ret.add(ele);
        }
        return ret;
    }
}