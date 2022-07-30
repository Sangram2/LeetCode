// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n = gas.length;
//         int delta = 0;
//         for(int i =0;i<n;i++){
//             delta+=gas[i]-cost[i];
//         }
//         if(delta<0){
//             return -1;
//         }
//         for(int i = 0;i<n;i++){
//             if(gas[i]>=cost[i]){
//                 int start = i;
//                 int itr = i;
//                 int fuel = gas[i];
//                 int c = cost[i];
//                 int ns = 0;
//                 while(ns!=n){
//                     if(fuel>=c){
//                         itr= (itr+1)%n;
//                         fuel += gas[itr]-c;
//                         c= cost[itr];
//                         ns++;
//                     }
//                     else{
//                         i = itr;
//                         break;
//                     }
//                 }
//                 if(ns==n){
//                     return start;
//                 }
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int csum = 0;
        int osum = 0;
        int si = 0;
        
        for(int i = 0; i < gas.length; i++){
            int delta = gas[i] - cost[i];
            
            osum += delta;
            csum += delta;
            
            if(csum < 0){
                csum = 0;
                si = i + 1;
            }
        }
        
        if(osum >= 0){
            return si;
        } else {
            return -1;
        }
    }
}