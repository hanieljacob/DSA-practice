import java.util.ArrayList;
import java.util.List;

class HowSum{

    // Brute Force where m = targetSum, n = size of array
    // Time Complexity: O(n^m)
    // Space Complexity: O(m)
    private static List<Integer> bruteForce(int targetSum, int[] arr){
        if(targetSum < 0){
            return null;
        }
        if(targetSum == 0){
            return new ArrayList<>();
        }
        for(int num: arr){
            List<Integer> result = bruteForce(targetSum - num, arr);
            if(bruteForce(targetSum - num, arr)!=null){
                result.add(num);
                return result;
            }
        }
        return null;
    }

    // Memoization
    // Time Complexity: O(n*m)
    // Space Complexity O(m^2)
    private static List<Integer> memoization(int targetSum, int [] arr, int[]dp){
        if(targetSum == 0){
            return new ArrayList<>();
        }
        if(targetSum < 0){
            return null;
        }
        if(dp[targetSum] == 1){
            return null;
        }
        for(int num: arr){
            List<Integer> result = memoization(targetSum - num, arr, dp);
            if(memoization(targetSum - num, arr, dp)!=null){
                result.add(num);
                return result;
            }
        }
        dp[targetSum] = 1;
        return null;
    }

    public static void main(String [] args){
        System.out.println(bruteForce(300, new int[]{7,14}));
        System.out.println(memoization(300, new int[]{7,14}, new int[301]));
    }
}