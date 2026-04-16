class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_set = [set() for _ in range(9)]
        col_set = [set() for _ in range(9)]
        box_set = [set() for _ in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    box_index = (i//3)*3 + j//3
                    if board[i][j] in row_set[i] or board[i][j] in col_set[j] or board[i][j] in box_set[box_index]:
                        return False
                    row_set[i].add(board[i][j])
                    col_set[j].add(board[i][j])
                    box_set[box_index].add(board[i][j])
        return True
                    