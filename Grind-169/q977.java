class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        int start = 0;
        int end = nums.length-1;
        int k = nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                ans[k] = nums[start] * nums[start];
                start++;
            }
            else{
                ans[k] = nums[end] * nums[end];
                end--;
            }
            k--;
        }
        return ans;
    }
}