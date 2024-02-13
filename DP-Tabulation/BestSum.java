import java.util.ArrayList;
import java.util.List;

public class BestSum {
    
    // Time Complexity: O(m^2 * n)
    // Space Complexity: O(m^2)
    private static List<Integer> bestSum(int targetSum, int[]numbers){
        List<Integer>[] table = new List[targetSum+1];
        table[0] = new ArrayList<>();
        for(int i=0; i<targetSum; i++){
            if(table[i]!=null){
                for(int num: numbers){
                    if(i+num <= targetSum){
                        if(table[i+num] == null){
                            table[i+num] = new ArrayList<>(table[i]);
                            table[i+num].add(num);
                        }
                        else{
                            List<Integer> temp = new ArrayList<>(table[i]);
                            temp.add(num);
                            if(temp.size() < table[i+num].size()){
                                table[i+num] = new ArrayList<>(temp);
                            }
                        }
                    }
                }
            }
        }
        return table[targetSum];
    }

    public static void main(String [] args){
        System.out.println(bestSum(8,new int[]{5,2,3}));
    }
}
