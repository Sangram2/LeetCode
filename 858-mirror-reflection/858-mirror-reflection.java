class Solution {
    int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int mirrorReflection(int p, int q) {
        int product = p*q;
        int gcd = gcd(p,q);
        int lcm = product/gcd;
        
        int x = lcm/p;
        if(x%2==0){
            return 0;
        }
        
        int y = lcm/q;
        if(y%2==0){
            return 2;
        }
        else{
            return 1;
        }
        
    }
    
}