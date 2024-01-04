class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(target > nums[mid])
                low = mid+1;
            else if (target < nums[mid])
                high = mid-1;
            else
                return mid;
        }
        System.gc();
        return -1;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)