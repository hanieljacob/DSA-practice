public class CanSum {

    // Time Complexity: O(mn)
    // Space Complexity: O(m)
    private static boolean canSum(int targetSum, int[]numbers){
        boolean [] table = new boolean[targetSum+1];
        table[0] = true;
        for(int i=0; i<targetSum; i++){
            if(table[i] == true){
                for(int num: numbers){
                        if(i+num <= targetSum && table[i+num] == false){
                            table[i+num] = true;
                        }
                    }
            }
        }
        return table[targetSum];
    }  

    public static void main(String [] args){
        System.out.println(canSum(7, new int[]{3,4,5}));
    }
}
