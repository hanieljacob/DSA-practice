import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)   return intervals;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] currentInterval = intervals[0];
        ans.add(currentInterval);
        for(int [] interval: intervals){
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            if(currentEnd >= nextBegin){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else{
                currentInterval = interval;
                ans.add(currentInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}