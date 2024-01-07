class Solution {
    public int[] countBits(int n) {
        if(n==0) return new int[1];
        int [] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            int count = 0;
            int k=i;
            while(k!=0){
             k = k & k-1;
             count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}