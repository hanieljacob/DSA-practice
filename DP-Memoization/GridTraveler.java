class GridTraveler{

    // Brute Force
    // Time Complexity: O(2^(m+n))
    // Space Complexity: O(m+n)
    private static long bruteForce(int m, int n){
        if(m == 1 && n == 1){
            return 1;
        }
        if(m == 0 || n == 0){
            return 0;
        }
        return bruteForce(m-1, n) + bruteForce(m, n-1);
    }

    // Memoization
    // Time Complexity: O(m*n)
    // Space Complexity: O(m + n)
    private static long memoization(int m, int n, long dp[][]){
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        if(m == 1 && n == 1){
            return 1; 
        }   
        if (m == 0 || n == 0){
            return 0;
        }
        dp[m][n] = memoization(m-1, n, dp) + memoization(m, n-1, dp);
        return dp[m][n];
    }

    public static void main(String [] args){
        System.out.println(bruteForce(18, 18));
        System.out.println(memoization(18, 18, new long[19][19]));
    }
}