# Solved (Medium)

class Solution(object):

    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """

        fails = False;

        for row in range(9):
            for col in range(9):
                if board[row][col] != ".":
                    if not Solution().validate(board, row, col, board[row][col]):
                        return False
        return True

    def validate(self, grid, row, col, n):
        """
        :type grid: List[List[str]]
        :type row: int
        :type col: int
        :type n: str
        """
        for x in range(9):
            if col != x and grid[row][x] == n:
                return False
        for x in range(9):
            if row != x and grid[x][col] == n:
                return False

        boxRow = row - row % 3
        boxCol = col - col % 3

        for x in range(3):
            for y in range(3):
                if x + boxRow != row and y + boxCol != col and grid[boxRow + x][boxCol + y] == n:
                    return False
        return True


board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]

print(Solution.isValidSudoku(board))