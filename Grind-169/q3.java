import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i=0; i<s.length(); i++){
            Set<Character> hashSet = new HashSet<>();
            int sum = 0;
            for(int j=i; j<s.length(); j++){
                if(hashSet.contains(s.charAt(j))){
                    if(sum>max)
                        max = sum;
                    break;
                }
                hashSet.add(s.charAt(j));
                sum++;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}

class Solution2{
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int n=s.length();
        int max = 0;
        Set<Character> hashSet = new HashSet<>();
        while(j<n){
            if(hashSet.contains(s.charAt(j))){
                hashSet.remove(s.charAt(i));
                i++;
            }
            else{
                hashSet.add(s.charAt(j));
                max = Math.max(hashSet.size(),max);
                j++;
            }
        }
        return max;
    }
}