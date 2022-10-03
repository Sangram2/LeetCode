class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        for(int i = 0;i<colors.length()-1;i++){
            int c1 = colors.charAt(i);
            int c2 = colors.charAt(i+1);
            int sum = 0;
            int max = 0;
            if(c1 == c2){
                sum = neededTime[i];
                max = neededTime[i];
                
            }
            while(i<colors.length()-1 && colors.charAt(i) == colors.charAt(i+1)){
                sum += neededTime[i+1];
                max = Math.max(max,neededTime[i+1]);
                i++;
            }
            ans += sum-max;
        }
        
        return ans;
    }
}