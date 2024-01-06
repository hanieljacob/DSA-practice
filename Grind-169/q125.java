class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                str.append(Character.toLowerCase(ch));
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}

// Time Complexity: O(n + m)
// Space Complexity: O(m)

class Solution2{
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(!Character.isLetterOrDigit(s.charAt(start)))
                start++;
            else if(!Character.isLetterOrDigit(s.charAt(end)))
                end--;
            else if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
                start++;
                end--;
            }
            else
                break;
        }
        return start>=end;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)