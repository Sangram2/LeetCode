class Solution {
    public String pushDominoes(String dominoes) {
        String d = "L"+dominoes+"R";
        int p1 =0;
        char[] arr = d.toCharArray();
        for(int i =0;i<arr.length;i++){
            if(arr[i] == 'L'){
                if(arr[p1]=='L'){
                    for(int k=p1+1;k<i;k++){
                        arr[k] = 'L';
                    }
                }
                else if(arr[p1]=='R'){
                    int lo = p1+1;
                    int hi = i-1;
                    
                    while(lo<hi){
                        arr[lo] = 'R';
                        arr[hi] = 'L';
                        lo++;
                        hi--;
                    }
                }
                
                p1 = i;
            }
            else if(arr[i] == 'R'){
                if(arr[p1]=='L'){
                    //do nothing
                }
                else if(arr[p1]=='R'){
                    for(int k=p1+1;k<i;k++){
                        arr[k] = 'R';
                    }
                }
                
                p1 = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<arr.length-1;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}