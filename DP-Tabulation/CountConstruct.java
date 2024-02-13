public class CountConstruct {

    // Time Complexity: O(m^2 * n)
    // Space Complexity: O(m)
    private static int countConstruct(String target, String[] wordBank){
        int[] table = new int[target.length()+1];
        table[0] = 1;
        for(int i=0; i<table.length; i++){
            if(table[i] != 0){
                for(String word: wordBank){
                    if(target.substring(i,target.length()).startsWith(word) && i + word.length() <= target.length()){
                        table[i+word.length()] += table[i];
                    }
                }
            }
        }
        return table[target.length()];
    }

    public static void main(String[] args){
        System.out.println(countConstruct("purple", new String[]{"purp","p","ur","le","purpl"}));
    }
}
