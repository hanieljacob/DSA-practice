class Solution {
    public boolean backspaceCompare(String s, String t) {
        String sFinalString = "";
        String tFinalString = "";
        for(char ch: s.toCharArray()){
            if(ch == '#'){
                if(sFinalString.length()!=0)
                    sFinalString = sFinalString.substring(0,sFinalString.length()-1);
            }
            else
                sFinalString += ch;
        }
        for(char ch: t.toCharArray()){
            if(ch == '#'){
                if(tFinalString.length()!=0)
                    tFinalString = tFinalString.substring(0,tFinalString.length()-1);
            }
            else
                tFinalString += ch;
        }
        return sFinalString.equals(tFinalString);
    }
}