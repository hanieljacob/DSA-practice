import java.util.ArrayList;
import java.util.List;

class Solution {
    private void findCombinations(int [] candidates, int target, int index, List<Integer> elements, List<List<Integer>> ans){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(elements));
            }
            return;
        }
        if(target >= candidates[index]){
            elements.add(candidates[index]);
            findCombinations(candidates, target - candidates[index], index, elements, ans);
            elements.remove(elements.size()-1);
        }
        findCombinations(candidates, target, index+1, elements, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}