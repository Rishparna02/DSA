//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length;


 //array to store minimum cost from first stone to ith stone.


 int[] dp = new int[n];


 Arrays.fill(dp,Integer.MAX_VALUE);


 


 //no cost from first stone to first stone 


 dp[0] = 0;


 


 for(int i=0;i<n;i++){


 for(int j=i+1;j<=k+i;j++){


 if(j < n){


 int cost = Math.abs(arr[i]-arr[j]);


 dp[j] = Math.min(dp[j], dp[i]+cost);


 }


 }


 }


 return dp[n-1];


 }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends