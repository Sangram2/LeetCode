class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        
        int mid1 = (m+n+1)/2;
        int mid2 = (m+n+2)/2;
        
        int median1 = find(nums1,nums2,mid1,0,0);
        int median2 = find(nums1,nums2,mid2,0,0);
        
        return (median1+median2)/2.0;
    }
    
    int find(int[] nums1,int[] nums2,int k,int s1,int s2){
        if(s1>=nums1.length){
            return nums2[s2+k-1];
        }
        if(s2>=nums2.length){
            return nums1[s1+k-1];
        }
        if(k==1){
            return Math.min(nums1[s1],nums2[s2]);
        }
        int ele1 = Integer.MAX_VALUE;
        int ele2 = Integer.MAX_VALUE;
        if(s1+k/2-1<nums1.length)
            ele1 = nums1[s1+k/2-1];
        if(s2+k/2-1<nums2.length)
            ele2 = nums2[s2+k/2-1]; 
        
        if(ele1<ele2){
            return find(nums1,nums2,k-k/2,s1+k/2,s2);
        }
        else{
             return find(nums1,nums2,k-k/2,s1,s2+k/2);
        }
    }
}

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int t = nums1.length+nums2.length;
//         int k1 = t+1,k2 = t+1,f = 1;
//         if(t%2==0){
//             k1 = t/2;
//             k2 = k1+1;
//             f = 2;
            
//         }
//         else{
//              k1 = (t+1)/2;
//              f = 1;
//         }
//         int sum = 0;
//         int count = 1;
//         int i = 0,j = 0;
//         while(count<=k2){
//             int ele =0;
//             if(i<nums1.length && j<nums2.length)
//                 ele = Math.min(nums1[i],nums2[j]);
//             else if(i<nums1.length){
//                 ele = nums1[i];
//             }else if(j<nums2.length){
//                 ele = nums2[j];
//             }
//             if(count==k1 || count==k2){
//                 sum+=ele;
//             }
//             if(i<nums1.length && j<nums2.length){
//                 if(nums1[i]<nums2[j]){
//                     i++;
//                 }
//                 else{
//                     j++;
//                 }
//             }
//             else{
//                 if(i<nums1.length){
//                     i++;
//                 }
//                 else{
//                     j++;
//                 }
//             }
            
//             count++;
//         }
//         return sum/(f*1.0);
//     }
// }