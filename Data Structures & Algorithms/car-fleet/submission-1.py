class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        ps_map = {}
        stack = []
        for p,s in zip(position, speed):
            ps_map[p] = s
        position.sort(reverse=True)
        for p in position:
            distance = target - p
            speed = ps_map[p]
            time = distance/speed
            if stack and time <= stack[-1]:
                continue
            stack.append(time)
        return len(stack)

