class Solution {
    
    public void reverse(int []row){
        int i=0,j=row.length-1;
        while(i<=j){
            int temp=row[i];
            row[i]=row[j];
            row[j]=temp;
            i++;
            j--;
        }
    }
    
    public void reverseRow(int [][]arr){
        for(int [] row : arr){
            reverse(row);
        }
    } 
    public void swap(int [][]arr,int i,int j){
        int temp=arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;
    }
    public void transpose(int [][]arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(arr,i,j);
            }
        }
    }
    public void rotate(int[][] arr) {
        //transpose
        transpose(arr);
        reverseRow(arr);
        
    }
}