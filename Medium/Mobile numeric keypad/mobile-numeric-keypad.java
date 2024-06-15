//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        
        int [][] transitions = {
            {0,8},
            {1,2,4},
            {1,2,3,5},
            {2,3,6},
            {1,4,5,7},
            {2,4,5,6,8},
            {3,5,6,9},
            {4,7,8},
            {0,5,7,8,9},
            {6,8,9}
        };
        long[][] dp = new long [n+1][10];
        
        for (int i = 0; i<10 ; i++){
            dp[1][i] = 1;
        }
        
        for (int len = 2; len <= n; len++){
            for (int digit = 0; digit<10; digit++){
                dp[len][digit] = 0;
                for (int prev : transitions[digit]){
                    dp[len][digit] += dp[len-1][prev];
                }
            }
        }
        long totalSequences = 0;
        for(int i = 0 ; i<10; i++){
            totalSequences += dp[n][i];
        }
        return totalSequences;
    }
}