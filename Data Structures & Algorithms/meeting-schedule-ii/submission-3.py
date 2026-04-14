"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        intervals.sort(key=lambda x:x.start)
        rooms = []
        for interval in intervals:
            room_found = False
            if not rooms:
                rooms.append(interval.end)
            else:
                for index, meeting_end_time in enumerate(rooms):
                    if interval.start >= meeting_end_time:
                        rooms[index] = interval.end
                        room_found = True
                        break
                if not room_found:
                    rooms.append(interval.end)
        return len(rooms)


        