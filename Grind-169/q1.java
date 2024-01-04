import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(numbers.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = numbers.get(target-nums[i]);
                return ans;
            }
            numbers.put(nums[i],i);
        }
        return ans;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)