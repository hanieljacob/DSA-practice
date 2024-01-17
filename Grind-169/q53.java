// O(n)
class Solution1{
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int num: nums){
            sum += num;
            if(sum > max)
                max = sum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}

// O(n^2)
class Solution2{
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=nums[j];
                max = Math.max(max,sum);
            } 
        }
        return max;
}
}

// O(n^3)
class Solution3{
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int k=0;
        for(int windowSize = 1; windowSize <= n; windowSize++){
            for(int i = 0; i <= n-windowSize; i++){
                int sum = 0;
                for(int j=i; j<i+windowSize; j++){
                    sum += nums[j];
                }
                max = Math.max(sum, max);
            }
    }
    return max;
}
}