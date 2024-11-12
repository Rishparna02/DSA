//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
     public void traverse(char[][] grid, int x, int y)
    {
        if(x>=grid.length || y>=grid[0].length || x<0 || y<0)return;
        if(grid[x][y]=='1')
        {
            grid[x][y]='0';
            traverse(grid, x+1, y);
            traverse(grid, x-1, y);
            traverse(grid, x, y+1);
            traverse(grid, x, y-1);
            traverse(grid, x-1, y-1);
            traverse(grid, x+1, y-1);
            traverse(grid, x-1, y+1);
            traverse(grid, x+1, y+1);
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int result=0;
        for(int i=0; i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    result+=1;
                    traverse(grid, i, j);
                }
            }
        }
        return result;
    }
}