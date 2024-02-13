import java.util.ArrayList;
import java.util.List;

public class AllConstruct {

    // Time Complexity: O(n^m)
    // Space Complexity: O(n^m) 
    private static List<List<String>> allConstruct(String target, String[] wordBank){
        List<List<String>>[] table = new List[target.length()+1];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ArrayList<>();
        }
        table[0].add(new ArrayList<>());
        for(int i=0; i<target.length(); i++){
            for(String word: wordBank){
                if(target.substring(i, target.length()).startsWith(word) && i+word.length()<=target.length()){
                    List<List<String>> temp = new ArrayList<>();
                    for(List<String> combination: table[i]){
                        List<String> newCombination = new ArrayList<>(combination);
                        newCombination.add(word);
                        temp.add(newCombination);
                    }
                    table[i+word.length()].addAll(temp);
                }
            }
        }
        return table[target.length()];
    }

    public static void main(String [] args){
        System.out.println(allConstruct("abc", new String[]{"a","b","c"}));
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    }
}
