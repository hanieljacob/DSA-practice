"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort(key = lambda x:x.start)
        index = 0
        n = len(intervals)
        while index+1 < n:
            if intervals[index].end > intervals[index+1].start:
                return False
            index += 1
        return True 