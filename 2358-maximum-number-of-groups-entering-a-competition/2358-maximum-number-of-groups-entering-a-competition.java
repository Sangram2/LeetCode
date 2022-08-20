class Solution {
    public int maximumGroups(int[] grades) {
        int ans = 0;
        
        int n = grades.length;
        int g = 1;
        while(g<=n){
            ans++;
            n-=g;
            g++;
        }
        return ans;
    }
}