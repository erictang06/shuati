package shuati.Matrix;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int rowSize = grid.length;
    if (rowSize == 0) {
      return 0;
    }

    int result = 0;
    int colSize = grid[0].length;

    for (int row = 0; row < rowSize; row++) {
      for (int col = 0; col < colSize; col++) {
        if (grid[row][col] == '1') {
          result++;
          dfs(grid, rowSize, colSize, row, col);
        }
      }
    }

    return result;
  }

  private void dfs(char[][] grid, int indexRow, int indexCol, int sizeRow, int sizeCol) {
    if (indexRow < 0 || indexCol < 0 || indexRow >= sizeRow || indexCol >= sizeCol || grid[indexRow][indexCol] == '0') {
      return;
    }

    grid[indexRow][indexCol] = '0';
    dfs(grid, indexRow-1, indexCol, sizeRow, sizeCol);
    dfs(grid, indexRow, indexCol-1, sizeRow,sizeCol);
    dfs(grid, indexRow+1, indexCol, sizeRow, sizeCol);
    dfs(grid, indexRow, indexCol+1, sizeRow, sizeCol);
  }
}
