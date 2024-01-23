import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Brute force
class BruteForce{
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> hashSet = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n-2;i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(temp);
                        hashSet.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(hashSet);
    }
}

// Two Pointer (Optimal)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int low = i+1;
            int high = nums.length-1;
            while(low<high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i],nums[low],nums[high])));
                    low++;
                    high--;
                    while(low<high && nums[low] == nums[low-1]) low++;
                    while(low<high && nums[high] == nums[high+1]) high--;
                }
                else if(sum > 0){
                    high--;
                    while(low<high && nums[high] == nums[high+1]) high--;
                }
                else{
                    low++;
                    while(low<high && nums[low] == nums[low-1]) low++;
                }
            }
        }
        return new ArrayList<>(triplets);
    }
}
