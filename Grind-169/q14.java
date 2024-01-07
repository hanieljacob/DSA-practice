class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String sub = strs[0];
        for(String str: strs)
            while(str.indexOf(sub)!=0)
                sub = sub.substring(0,sub.length()-1);
        return sub;
    }
}

// Time Complexity: O(m * n) m = Longest String in the array
// Space Complexity: O(1)