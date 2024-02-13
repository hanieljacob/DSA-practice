import java.util.HashMap;

class CanConstruct{

    // Brute Force, where n = size of word bank and m = height of tree (target length)
    // Time Complexity: O(n^m * m)
    // Space Complexity: O(m)
    private static boolean bruteForce(String target, String[] wordBank){
        if(target.isEmpty()){
            return true;
        }
        for(String word: wordBank){
            if(target.startsWith(word) && bruteForce(target.substring(word.length(),target.length()), wordBank)){
                return true;
            }
        }
        return false;
    }

    // Memoization
    // Time Compleity: O(n* m^2)
    // Space Complexity: O(m)
    private static boolean memoization(String target, String[] wordBank, HashMap<String, Boolean> dp){
        if(target.isEmpty()){
            return true;
        }
        if(dp.get(target)!=null){
            return dp.get(target);
        }
        for(String word: wordBank){
            if(target.startsWith(word) && memoization(target.substring(word.length(), target.length()), wordBank, dp)){
                return true;
            }
        }
        dp.put(target, false);
        return false;
    }

    public static void main(String [] args){
        System.out.println(bruteForce("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee", "eee","eeee","eeeee"}));
        System.out.println(memoization("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee", "eee","eeee","eeeeef"}, new HashMap<>()));
    }
}