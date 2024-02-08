class CanSum{

    // Brute Force
    // n = Size of arr, m = height of tree (targetSum) 
    // Time Complexity: O(n^m) 
    // Space Complexity: O(m)
    private static boolean bruteForce(int targetSum, int [] arr){
        if(targetSum < 0){
            return false;   
        }
        if(targetSum == 0){
            return true;
        }
        for(int num: arr){
            if(bruteForce(targetSum - num, arr)){
                return true;
            }
        }
        return false;
    }

    // Memoization
    // n = Size of arr, m = height of tree (targetSum) 
    // Time Complexity: O(n * m) 
    // Space Complexity: O(m)
    private static boolean memoization(int targetSum, int [] arr, int[]dp){
        if (targetSum < 0){
            return false;
        }
        if(targetSum == 0){
            return true;
        }
        if(dp[targetSum] == 1){
            return false;
        }
        for(int num: arr){
            if(memoization(targetSum - num, arr, dp)){
                return true;
            }
        }
        dp[targetSum] = 1;
        return false;
    }

    public static void main(String [] args){
        System.out.println(bruteForce(300, new int[]{7,14}));
        System.out.println(memoization(300, new int[]{7,14}, new int[301]));
    }
}