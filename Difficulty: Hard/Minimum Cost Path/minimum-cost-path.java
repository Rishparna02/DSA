//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    static class Node{
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost; 
        }
    }
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            return a.cost - b.cost;
        });
        
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];
        pq.add(new Node(0,0, grid[0][0]));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(int i = 0; i < 4 ; ++i){
                int nbrX = cur.x + dx[i];
                int nbrY = cur.y + dy[i];
                if(valid(nbrX, nbrY, n, m)){
                    if(cur.cost + grid[nbrX][nbrY] < dist[nbrX][nbrY]){
                        dist[nbrX][nbrY] = cur.cost + grid[nbrX][nbrY];
                        pq.add(new Node(nbrX, nbrY, dist[nbrX][nbrY]));
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
    boolean valid(int x, int y, int n, int m){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}