import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        int sum = 0;
        boolean oddCharacter = false;
        Map<Character, Integer> counts = new HashMap<>();
        for(char ch: s.toCharArray())
            counts.put(ch, counts.getOrDefault(ch,0)+1);
        for(Map.Entry<Character, Integer> entry: counts.entrySet()){
            if (entry.getValue()%2!=0){
                sum += entry.getValue()-1; 
                if(oddCharacter == false){
                    sum++;
                    oddCharacter = true;
                }
            }
            else{
                sum += entry.getValue();
            }
        }
        return sum;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(c) c = no. of distinct characetrs