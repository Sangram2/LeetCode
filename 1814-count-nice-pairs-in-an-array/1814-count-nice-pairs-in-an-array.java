class Solution {
//     public int rev(int n){
//         int ans= 0;
//         while(n>0){
//             int rem = n%10;
//             ans = (ans*10) + rem;
//             n/=10;    
//         }
//         return ans;
//     }
//     public int countNicePairs(int[] nums) {
        
//         int n = nums.length;
        
        
        
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         for(int i = 0;i<n;i++){
//             int key = nums[i]-rev(nums[i]);
//             hm.put(key,hm.getOrDefault(key,0)+1);
//         }
        
//         int rej = 0;
//         for(int k:hm.keySet()){
//             if(hm.get(k)>1){
//                 int h = hm.get(k);
//                 rej += h*(h-1)/2;
//             }
//         }
 
//         return rej%1000000007;
//     }
     public int countNicePairs(int[] A) {
        int res = 0, mod = (int)1e9 + 7;
        Map<Integer, Integer> count = new HashMap<>();;
        for (int a : A) {
            int b = rev(a), v = count.getOrDefault(a - b, 0);
            count.put(a - b, v + 1);
            res = (res + v) % mod;
        }
        return res;
    }

    public int rev(int a) {
        int b = 0;
        while (a > 0) {
            b = b * 10 + (a % 10);
            a /= 10;
        }
        return b;
    }
}
