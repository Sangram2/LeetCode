class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if(changed.length%2  == 1){
            return new int[0];
        }
        boolean zero = true;
        int f = 0;
        for(int i = 0;i<changed.length;i++){
            if(changed[i] != 0){
                zero = false;
            }else{
                f++;
            }
        }
        
        if(f%2==1){
            
            return new int[0];
        }
        if(zero){
            int[] a = new int[changed.length/2];
            Arrays.fill(a,0);
            return a;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int ele:changed){
            tm.put(ele,tm.getOrDefault(ele,0)+1);
            
        }
        int count = 0;
        for(int ele:tm.keySet()){
            if(ele == 0){
                int c = tm.get(0)/2;
                count += c;
                for(int i = 0;i<c;i++){
                    arr.add(0);
                }
            
                continue;
            }
            if(ele%2 == 0){
                if(tm.containsKey(ele/2)){
                    int count1 = tm.get(ele/2);
                    int count2 = tm.get(ele);
                    if(count2<count1){
                        
                        return new int[0];
                    }else{
                        int c = Math.min(count1,count2);
                        for(int i = 0;i<c;i++){
                            arr.add(ele/2);
                        }
                        count += c; 
                        tm.put(ele/2,0);
                        tm.put(ele,tm.get(ele)-c);
                    }
                }
            }
        }
        if(count!=changed.length/2){
            
            return new int[0];
        }
        int[] ar = new int[arr.size()];
        for(int i = 0;i<ar.length;i++){
            ar[i] = arr.get(i);
        }
        return ar;
    }
}