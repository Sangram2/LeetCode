class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int t = nums1.length+nums2.length;
        int k1 = t+1,k2 = t+1,f = 1;
        if(t%2==0){
            k1 = t/2;
            k2 = k1+1;
            f = 2;
            
        }
        else{
             k1 = (t+1)/2;
             f = 1;
        }
        int sum = 0;
        int count = 1;
        int i = 0,j = 0;
        while(count<=k2){
            int ele =0;
            if(i<nums1.length && j<nums2.length)
                ele = Math.min(nums1[i],nums2[j]);
            else if(i<nums1.length){
                ele = nums1[i];
            }else if(j<nums2.length){
                ele = nums2[j];
            }
            if(count==k1 || count==k2){
                sum+=ele;
            }
            if(i<nums1.length && j<nums2.length){
                if(nums1[i]<nums2[j]){
                    i++;
                }
                else{
                    j++;
                }
            }
            else{
                if(i<nums1.length){
                    i++;
                }
                else{
                    j++;
                }
            }
            
            count++;
        }
        return sum/(f*1.0);
    }
}
