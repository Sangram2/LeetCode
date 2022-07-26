class Solution {
    

    public int reachNumber(int target) {
        int jump = 1;
        int nt = Math.abs(target);
        while(true){
            int range = jump*(jump+1)/2;
            if(nt <= range && nt%2 == range%2){
                break;
            }
            jump++;
        }
        return jump;
    }
}