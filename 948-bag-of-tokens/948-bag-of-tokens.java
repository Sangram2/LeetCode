class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans = 0;
        int score = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        while(i<=j){
            while(i<=j && power>=tokens[i]){
                power-=tokens[i];
                i++;
                score++;
                ans = Math.max(ans,score);
            }
            if(score==0){
                break;
            }
            if(i<=j &&score>0){
                power+=tokens[j];
                j--;
                score--;
            }
        }
        return ans;
    }
}