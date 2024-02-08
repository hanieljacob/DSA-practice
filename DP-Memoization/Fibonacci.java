class Fibonacci{

    // Brute Force
    // Time complexity: O(2^n)
    // Space complexity: O(n)
    private static long bruteForce(int n){
        if(n<=2){
            return 1;
        }
        return bruteForce(n-1) + bruteForce(n-2);
    }

    // Memoization
    // Time Complexity: O(2n) = O(n)
    // Space Complexity: O(2n) = O(n)
    private static long memoization(int n, long[]dp){
        if(dp[n]!=0){
            return dp[n];
        }
        if(n<=2){
            return 1;
        }
        dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
        return dp[n];
    }

    public static void main(String [] args){
        System.out.println(bruteForce(50));
        System.out.println(memoization(50, new long[51]));
    }
}