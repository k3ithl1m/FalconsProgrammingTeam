//Question 200 leetcode, Number of Islands
// Depth first search.

class LCNumOfIslands {
    
    static int counter = 0;
    
    public int numIslands(char[][] grid) {
        counter = 0;
        
        // go through the whole grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    dfs(i, j, grid);
                    
                }
            }
        }
        
        return counter;
    }
    
    //Depth first search starts here.
    public char[][] dfs(int row, int column, char[][] grid) {
    		//check all sides
        if (grid[row][column] == '1') {
            grid[row][column] = '0';
            if (row + 1 != grid.length) {
                dfs(row + 1, column, grid);
            }
            if (row - 1 != -1) {
                dfs(row - 1, column, grid);
            }
            
            if (column + 1 != grid[0].length) {
                dfs(row, column + 1, grid);
            }
            
            if (column - 1 != -1) {
                dfs(row, column - 1, grid);
            }
        }
        
    
        return grid;
    }
}