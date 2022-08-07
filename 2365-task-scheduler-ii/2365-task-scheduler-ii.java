class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> hm = new HashMap<>();
        long res = 0;
        for(int task:tasks){
            if(hm.containsKey(task)){
                hm.put(task,res = Math.max(hm.get(task)+space,res)+1);
            }
            else{
                hm.put(task,++res);
            }
        }
        return res;
    }
}