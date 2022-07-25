class Solution {
    public int findfi(int []a,int n,int x){
        if(n==0){
            return -1;
        }
        int fi=-1;
    
        int st=0,end=n-1;
        while(st<=end){
            int mid=st+((end-st)/2);
            if(a[mid]==x){
                fi=mid;
                end=mid-1;
            }
            else if(a[mid]>x){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return fi;
    }
    public int findli(int []a,int n,int x){
        if(n==0){
            return -1;
        }
        int li=-1;
        int st=0,end=n-1;
        while(st<=end){
            int mid=st+((end-st)/2);
            if(a[mid]==x){
                li=mid;
                st=mid+1;
            }
            else if(a[mid]>x){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return li;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int n=nums.length;
        ans[0]=findfi(nums,n,target);
        ans[1]=findli(nums,n,target);
        return ans;
    }
}