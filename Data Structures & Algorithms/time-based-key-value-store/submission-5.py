class TimeMap:

    def __init__(self):
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map:
            return ""
        values = self.map[key]
        if timestamp < values[0][0]:
            return ""
        left, right = 0, len(values)-1
        while left <= right:
            mid = (left+right)//2
            ts, _ = values[mid]
            if timestamp < ts:
                right = mid-1
            else:
                left = mid+1
        return values[right][1]
        
