class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum ^= num;
        return sum;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)