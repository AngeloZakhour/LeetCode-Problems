# Solved (Hard)

class Solution(object):

    solved = False
    solvedBoard = [[] for x in range(9)]

    def valid(self, grid, row, col, n):
        for x in range(9):
            if col != x and grid[row][x] == "{}".format(n):
                return False
        for x in range(9):
            if row != x and grid[x][col] == "{}".format(n):
                return False

        boxRow = row - row % 3
        boxCol = col - col % 3

        for x in range(3):
            for y in range(3):
                if x + boxRow != row and y + boxCol != col and grid[boxRow + x][boxCol + y] == "{}".format(n):
                    return False
        return True

    def solve(self, board):
        if Solution().solved:
            return
        for row in range(9):
            for col in range(9):
                if board[row][col] == ".":
                    for n in range(1, 10):
                        if Solution().valid(board, row, col, n):
                            board[row][col] = "{}".format(n)
                            Solution().solve(board)
                            if not Solution().solved:
                                board[row][col] = "."
                    return

        print(board)
        for i in range(9):
            for j in range(9):
                Solution().solvedBoard[i].insert(j, board[i][j])
        Solution().solved = True
        return

    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        newBoard = [[] for x in range(9)]
        for i in range(9):
            for j in range(9):
                newBoard[i].insert(j, board[i][j])

        Solution().solve(newBoard)

        for i in range(9):
            for j in range(9):
                board[i][j] = Solution().solvedBoard[i][j]




boardy = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]

Solution().solveSudoku(boardy)

print("this is board: ",  boardy)
print(Solution().solvedBoard)