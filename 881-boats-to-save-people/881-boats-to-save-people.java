class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length-1;
        
        while(i<j){
            if(people[i]+people[j]>limit){
                j--;
                count++;
            }else{
                i++;
                j--;
                count++;
            }
        }
        
        if(i==j){
            count+=1;
        }
        return count;
    }
}