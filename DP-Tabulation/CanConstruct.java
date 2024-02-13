public class CanConstruct {

    // Time Complexity: O(m^2 * n)
    // Space Complexity: O(m)
    private static boolean canConstruct(String target, String[] wordBank){
        boolean[] table = new boolean[target.length()+1];
        table[0] = true;
        for(int i=0; i<target.length(); i++){
            if(table[i]!=false){
                for(String word: wordBank){
                    if(target.substring(i, target.length()).startsWith(word) && i+word.length()<=target.length()){
                        table[i+word.length()] = true;
                    }
                }
            }
        }
        return table[target.length()];
    }

    public static void main(String[] args){
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));

    }    
}
