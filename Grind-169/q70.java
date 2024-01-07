class Solution {
    public int climbStairs(int n) {
        // if(n<=1)
        //     return 1;
        // return climbStairs(n-1) + climbStairs(n-2);
        int n1 = 1;
        int n2 = 2;
        int n3 = 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        for(int i=2;i<n;++i)   
        {    
            n3=n1+n2;    
            n1=n2;    
            n2=n3;    
        }
        return n3;    
    }
}