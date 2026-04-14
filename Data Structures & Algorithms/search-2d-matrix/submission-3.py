class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        m = len(matrix)-1
        n = len(matrix[0])-1

        def binary_search(index):
            left, right = 0, n
            while left <= right:
                mid = (left+right)//2
                if target == matrix[index][mid]:
                    return True
                if target > matrix[index][mid]:
                    left = mid+1
                else:
                    right = mid-1
            return False

        left, right = 0, m
        while left <= right:
            mid = (left+right)//2
            print(mid)
            if target == matrix[mid][0] or target == matrix[mid][-1]:
                return True
            if target > matrix[mid][0] and target < matrix[mid][-1]:
                return binary_search(mid)
            elif target < matrix[mid][0]:
                right = mid-1
            else:
                left = mid+1
        return False

        