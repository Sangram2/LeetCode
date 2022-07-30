class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int []> arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<firstList.length && j<secondList.length){
            int[] l1 = firstList[i];
            int[] l2 = secondList[j];
            int left = Math.max(l1[0],l2[0]);
            int right = Math.min(l1[1],l2[1]);
            
            if(left <= right){
                arr.add(new int[]{left,right});
            }
            
            if(l1[1]<l2[1]){
                i++;
            }
            else{
                j++;
            }
        }
        
        return arr.toArray(new int[arr.size()][2]);
    }
}