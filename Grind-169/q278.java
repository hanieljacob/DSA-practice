class VersionControl{ 
    boolean isBadVersion(int version){
        return true;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int mid;
        while (low <= n) {
            mid = low + (n - low) / 2;
            if (isBadVersion(mid) == true) {
                n = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)