import java.util.Collections;
import java.util.List;


 class Interval {
    int start, end;
    Interval(int start, int end) {
    this.start = start;
    this.end = end;
}
}


class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for(int i = 0; i<intervals.size()-1;i++){
            if(intervals.get(i+1).start < intervals.get(i).end)
                return false;
        }
        return true;
    }
}