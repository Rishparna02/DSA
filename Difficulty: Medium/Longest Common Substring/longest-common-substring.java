//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int[][] dp = new int[str1.length()][str2.length()];
        int max = 0;
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    if ( i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}