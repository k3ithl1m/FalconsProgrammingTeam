/*
 * Leet Code questions Unique Paths and Unique Paths 2
 * DP and Array
 */
public class LCUniquePaths {
	
	class UniquePaths {
	    public int uniquePaths(int m, int n) {
	        int[][] mn = new int[m][n];
	        for (int i = 0; i< m; i++) {
	            for (int j = 0; j< n; j++) {
	                if (i == 0 || j == 0) {
	                    mn[i][j] = 1;
	                } else {
	                    mn[i][j] = mn[i-1][j] + mn[i][j-1];
	                }
	            }
	        }
	        
	        return mn[m -1][n -1];
	    }
	}
	
	class UniquePathsWithObstacles {
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if (obstacleGrid[0][0] == 1) return 0;
	        int[][] ar = new int[obstacleGrid.length][obstacleGrid[0].length];
	        
	        for (int i = 0; i < obstacleGrid.length; i++) {
	            if (obstacleGrid[i][0] != 1) ar[i][0] = 1;
	            else {break;}
	        }
	        
	        for (int j = 0; j < obstacleGrid[0].length; j++) {
	            if (obstacleGrid[0][j] != 1) ar[0][j] = 1;
	            else {break;}
	        }
	        
	        for (int i = 1; i < obstacleGrid.length; i++) {
	            for (int j = 1; j < obstacleGrid[0].length; j++) {
	                System.out.println(ar[i-1][j]);
	                if (obstacleGrid[i][j] != 1) {
	                    ar[i][j] = ar[i - 1][j] + ar[i][j-1];
	                }
	            }
	        }
	        
	        return ar[obstacleGrid.length -1][obstacleGrid[0].length -1];
	        
	    }
	}
}
