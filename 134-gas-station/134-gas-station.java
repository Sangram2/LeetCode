class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int delta = 0;
        for(int i =0;i<n;i++){
            delta+=gas[i]-cost[i];
        }
        if(delta<0){
            return -1;
        }
        for(int i = 0;i<n;i++){
            if(gas[i]>=cost[i]){
                int start = i;
                int itr = i;
                int fuel = gas[i];
                int c = cost[i];
                int ns = 0;
                while(ns!=n){
                    if(fuel>=c){
                        itr= (itr+1)%n;
                        fuel += gas[itr]-c;
                        c= cost[itr];
                        ns++;
                    }
                    else{
                        i = Math.max(itr,start);
                        break;
                    }
                }
                if(ns==n){
                    return start;
                }
            }
        }
        return -1;
    }
}