import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class BestSum{

    // Brute Force where m = targetSum, n = size of array
    // Time Complexity: O(n^m)
    // Space Complexity: O(m^2)
    private static List<Integer> bruteForce(int targetSum, int[] arr){
        if(targetSum == 0){
            return new ArrayList<>();
        }
        if(targetSum < 0){
            return null;
        }
        List<Integer> best = null;
        for(int num: arr){
            List<Integer> list = bruteForce(targetSum - num, arr);
            if(list!=null){
                list.add(num);
                if(best == null || list.size() < best.size()){
                    best = list;
                }
            }
        }
        return best;
    }

    // Memoization where m = targetSum, n = size of array
    // Time Complexity: O(m*n)
    // Space Complexity: O(m^2)
    private static List<Integer> memoization(int targetSum, int [] arr, HashMap<Integer, List<Integer>> dp){
        if(targetSum < 0){
            return null;    
        }
        if(targetSum == 0){
            return new ArrayList<>();
        }
        if(dp.containsKey(targetSum)){
            return new ArrayList<>(dp.get(targetSum)); 
        }
        List<Integer> best = null;
        for(int num: arr){
            List<Integer> combination = memoization(targetSum - num, arr, dp);
            if(combination != null){
                combination.add(num);   
                if(best == null || best.size() > combination.size()){
                    best = combination;
                }
            }
        }
        dp.put(targetSum, best);
        return new ArrayList<>(best);
    }

    public static void main(String [] args){
        System.out.println(bruteForce(100, new int[]{1,2,5,25}));
        System.out.println(memoization(10, new int[]{1,2,5}, new HashMap<>()));
    }
}