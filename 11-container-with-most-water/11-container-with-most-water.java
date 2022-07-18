class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int st = 0;
        int end = height.length-1;
        while(st<end){
            int left = height[st];
            int right = height[end];
            int diff = end-st;
            int h = Math.min(left,right);
            int area = h*diff;
            ans = Math.max(area,ans);
            if(left<right){
                st++;
            }
            else{
                end--;
            }
        }
        
        return ans;
    }
}