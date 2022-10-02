class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        //to store the number of ways using bottom up approach
        //dp array holds the row value as number of dice
        // and col value as target
        int[][] dp  = new int[d+1][target+1];
        
        //base case ==>
        // if target = 0 and number of dice is zero
        // then we can only have one way i.e, not doing anything => one way
        
        dp[0][0] = 1;
        
        //mod val
        //simply use built in 1e and specify power value to get 10power number (in JAVA)
        
        int mod = (int) 1e9 + 7;
        
        for(int dice = 1;dice <= d ; dice++){
            for(int target_val = 0;target_val<=target ; target_val++){
                for(int face_val = 1; face_val<=f ; face_val++){
                    //check if target_val is greater than face val and proceed
                    
                    if(target_val >= face_val){
                        // way of getting target with current dice is 
                        //sum of ways of getting target with previous dice with target as currtarget - facevalue
                        //plus curr ways
                        dp[dice][target_val] = (dp[dice][target_val] + dp[dice-1][target_val - face_val])%mod;
                    }
                }
            }
        }
        
        return dp[d][target];
    }
}