class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] counts = new int[26];
        for(char ch: magazine.toCharArray())
            counts[ch-'a']++;
        for(char ch: ransomNote.toCharArray()){
            if(--counts[ch-'a'] == -1)
                return false;
        }
        return true;
    }
}

// Time Complexity: O(m+n)
// Space Complexity: O(1)