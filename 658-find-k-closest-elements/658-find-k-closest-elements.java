class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        
        int start = arr[0];
        int end = arr[n-1];
        
        List<Integer> ans = new ArrayList<>();
        if(x<=start){
            for(int i =0;i<k;i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        if(x>=end){
            for(int i = n-k;i<n;i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        
        
        int fIndex = -1;
        int hi = n-1;
        int lo = 0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid]==x){
                fIndex = mid;
                hi = mid-1;
                
            }
            else if(arr[mid]>x){
                hi = mid-1;
            }else{
                lo = mid+1;
                
            }
        }
        int f = k;
        int p1 = -1;
        int p2 = -1;
        if(fIndex!=-1){
             p1 = fIndex-1;
             p2 = fIndex+1;
            ans.add(arr[fIndex]);
            f--;
        }
        else if(arr[hi]>x){
            p1 = hi-1;
            p2 = hi;
        }
        else if(arr[hi]<x){
            p1 = hi;
            p2 = hi+1;
        }
        
        while(f>0){
            int s1 = Integer.MAX_VALUE;
            int s2 = Integer.MAX_VALUE;
            if(p1>=0)
                s1 = Math.abs(x-arr[p1]);
            if(p2<arr.length)
                 s2 = Math.abs(x-arr[p2]);
            
            if(s1<s2){
                ans.add(arr[p1]);
                p1--;
                f--;
            }
            else if(s2<s1){
                ans.add(arr[p2]);
                p2++;
                f--;
            }
            else{
                ans.add(arr[p1]);
                p1--;
                f--;
            }
        }
        Collections.sort(ans);
        return ans;
        
        
    }
}