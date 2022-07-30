class Solution {
    long MOD = 1000000007;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long p = 1;
        long ans = 0;
        for(int i = 0;i<nums.length;i++){
           ans=(ans+nums[i]*p - p*nums[nums.length-1-i])%MOD;
            p = (p*2)%MOD;
        }
        return (int)ans;
    }
}