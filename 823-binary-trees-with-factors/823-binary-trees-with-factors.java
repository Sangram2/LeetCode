class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer,Long> hm = new HashMap<>();
        Arrays.sort(arr);
        for(int ele:arr){
            hm.put(ele,1L);
        }
        long res = 0;
        int mod = (int)1e9+7;
        
        for(int i=1;i<arr.length;i++){
            for(int j = 0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    hm.put(arr[i],((hm.get(arr[i])%mod) + ((hm.get(arr[j]) * hm.getOrDefault(arr[i]/arr[j],0L))%mod))%mod);
                }
            }
        }
        for(int ele:arr){
            res=(res+hm.get(ele))%mod;
        }
        return (int)res;
    }
}