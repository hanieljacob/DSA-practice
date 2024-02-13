import java.util.ArrayList;
import java.util.List;

class Solution {
    private void dfs(int [] nums, List<Integer> elements, boolean [] visited, List<List<Integer>> ans){
        if(elements.size() == nums.length){
            ans.add(new ArrayList<>(elements));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                elements.add(nums[i]);
                visited[i] = true;
                dfs(nums, elements, visited, ans);
                elements.remove(elements.size()-1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        boolean [] visited = new boolean[nums.length];
        dfs(nums, elements, visited, ans);
        return ans;
    }
}