import java.util.ArrayList;
import java.util.List;

public class HowSum {
    
    // Time Complexity: O(m^2 * n)
    // Space Complexity: O(m^2);
    private static List<Integer> howSum(int targetSum, int[] numbers){
        List<Integer>[] table = new ArrayList[targetSum+1];
        table[0] = new ArrayList<>();   
        for(int i=0; i<targetSum; i++){
            if(table[i]!=null){
                for(int num: numbers){
                    if(i+num <= targetSum){
                        table[i+num] = new ArrayList<>(table[i]);
                        table[i+num].add(num);
                    }     
                }
            }
        }
        return table[targetSum];
    }

    public static void main(String [] args){
        System.out.println(howSum(7, new int[]{3,4,5}));
    }
}
