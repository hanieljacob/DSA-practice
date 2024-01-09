class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int num: nums)
            sum += num;
        return (len*(len+1))/2 - sum;
    }
}