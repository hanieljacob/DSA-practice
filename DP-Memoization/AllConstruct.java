import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AllConstruct{

    // Brute Force, where n = size of word bank and m = height of tree (target length)
    // Time Complexity: O(n^m)
    // Space Complexity: O(m)
    private static List<List<String>> bruteForce(String target, String[] wordBank){
        if (target.isEmpty()) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<String>> possibleWays = new ArrayList<>();
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixPossibleWays = bruteForce(suffix, wordBank);
                for (List<String> way : suffixPossibleWays) {
                    List<String> combination = new ArrayList<>(way);
                    combination.add(0, word);
                    possibleWays.add(combination);
                }
            }
        }
        return possibleWays;
    }

    // Memoization
    // Time Complexity: O(n^m)
    // Space Complexity: O(m)
    private static List<List<String>> memoization(String target, String[] wordBank, HashMap<String, List<List<String>>> dp){
        if(dp.get(target)!=null){
            return dp.get(target);
        }
        if(target.isEmpty()){
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<String>> possibleWays = new ArrayList<>();
        for(String word: wordBank){
            if(target.startsWith(word)){
                String slicedString = target.substring(word.length(),target.length());
                List<List<String>> combinations = memoization(slicedString, wordBank, dp);
                for(List<String> combination: combinations){
                    List<String> res = new ArrayList<>(combination);
                    res.add(0, word);
                    possibleWays.add(res);
                } 
            }
        }
        dp.put(target, possibleWays);
        return possibleWays;
    }

    public static void main(String [] args){
        System.out.println(bruteForce("abc", new String[]{"a","b","c","ab","ac"}));
        System.out.println(memoization("abc", new String[]{"a","b","c","ab","ac"}, new HashMap<>()));
    }
}