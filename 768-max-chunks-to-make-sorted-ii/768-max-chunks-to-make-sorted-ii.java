class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] min = new int[arr.length];
        min[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            min[i] = Math.min(arr[i],min[i+1]);
        }
        for(int ele:min){
            System.out.println(ele+" ");
        }
        
        int ans = 0;
        int max = Integer.MIN_VALUE;        
        for(int i=0;i<arr.length-1;i++){
            max = Math.max(max,arr[i]);
            if(max<=min[i+1]){
                ans++;
            }
        }
        return ans+1;
    }
}