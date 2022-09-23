class Solution {
    public int concatenatedBinary(int n) {
        int ans = 0;
        int mod = (int)1e9+7;
        for(int i = 1;i<=n;i++){
            String br = Integer.toBinaryString(i);
            for(char c:br.toCharArray()){
                int val = (c=='0') ? 0:1;
                ans = ((ans*2)%mod+val)%mod;
            }
        }
        return ans;
    }
}