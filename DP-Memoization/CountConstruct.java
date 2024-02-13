import java.util.HashMap;

class CountConstruct{

    // Brute Force, where n = wordBank.length() and m = height of tree (target.length())
    // Time Complexity: O(n^m * m)
    // Space Complexity: O(m^2)
    private static int bruteForce(String target, String[] wordBank){
        if(target.isEmpty()){
            return 1;
        }
        int count = 0;
        for(String word: wordBank){
            if(target.startsWith(word)){
                count += bruteForce(target.substring(word.length(),target.length()), wordBank);
            }
        }
        return count;
    }

    // Memoization
    // Time Complexity: O(n*m * m)
    // Space Complexity: O(m^2)
    private static int memoization(String target, String[] wordBank, HashMap<String, Integer> dp){
        if(target.isEmpty()){
            return 1;
        }
        if(dp.get(target)!=null){
            return dp.get(target);
        }
        int count = 0;
        for(String word: wordBank){
            if(target.startsWith(word)){
                count += memoization(target.substring(word.length(), target.length()), wordBank, dp);
            }
        }
        dp.put(target, count);
        return count;
    }

    public static void main(String [] args){
        System.out.println(bruteForce("abcdef", new String[]{"ab","abc","cd","def","abcd"}));
        System.out.println(memoization("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee", "eee","eeee"}, new HashMap<>()));
    }
}